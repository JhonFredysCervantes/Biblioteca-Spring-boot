package com.biblioteca.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Sede;
import com.biblioteca.model.SedeLibro;
import com.biblioteca.services.ISedeService;

@RestController
@RequestMapping("/sede")
public class SedeController {

	@Autowired 
	ISedeService sService;
	
	/*http://localhost:8080/sede/...*/
	
	//CREAR UNA SEDE
	@PostMapping
	public Sede crear(@RequestBody Sede s) {
		return sService.crearSede(s);
	}
	
	//EDITAR UNA SEDE
	@PutMapping("/{id}")
	public Sede editar(@RequestBody Sede s, @PathVariable("id") Long id) {
		
		if(id!=null) {
			Optional<Sede> resultado = sService.buscarSedeId(id);
			
			if(resultado.isPresent()) {
				Sede oldSede = resultado.get();
						
				String nombre = s.getNombre();
				oldSede.setNombre(nombre);
				
				Long telefono = s.getTelefono();
				oldSede.setTelefono(telefono);
				
				String direccion = s.getDireccion();
				oldSede.setDireccion(direccion);
				
				Set<Prestamo> prestamos = s.getPrestamos();
				oldSede.setPrestamos(prestamos);
				
				List<SedeLibro> materiales = s.getMateriales();
				oldSede.setMateriales(materiales);
				
				return sService.actualizarSede(oldSede);
			}
		}
		return null;
	}
	
	//BUSCAR POR NOMBRE DE SEDE
	@GetMapping("/buscarNombre/{name}")
	public List<Sede> buscarPorNombre(@PathVariable("name")String nombre) {
		return sService.buscarPorNombre(nombre);
	}
	
	//BUSCAR POR DIRECCIÓ DE SEDE
	@GetMapping("/buscarDireccion/{dir}")
	public Sede buscarPorDireccion(@PathVariable("dir")String direccion) {
		return sService.buscarPorDireccion(direccion);
	}
	
	//ELIMINAR UNA SEDE
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		sService.eliminarSede(id);
	}
	
	//LISTANDO TODAS LAS SEDES
	@GetMapping
	public List<Sede> listarSedes(){
		return sService.listarTodosSedes();
	}
	
	
}
