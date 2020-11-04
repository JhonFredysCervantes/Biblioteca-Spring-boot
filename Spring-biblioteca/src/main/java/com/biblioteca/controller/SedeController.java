package com.biblioteca.controller;

import java.util.List;
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
	@PostMapping("/crear")
	public Sede crear(@RequestBody Sede s) {
		return sService.crearSede(s);
	}
	
	//EDITAR UNA SEDE
	@PutMapping("/editar/{id}")
	public Sede editar(@RequestBody Sede s, @PathVariable("id") Long id) {
		Sede oldSede = sService.buscarSedeId(id);
		
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
	
	//ELIMINAR UNA SEDE
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		Sede s = sService.buscarSedeId(id);
		sService.eliminarSede(s);
	}
	
	//LISTANDO TODAS LAS SEDES
	@GetMapping("/listarsedes")
	public List<Sede> listarSedes(){
		return sService.listarTodosSedes();
	}
	
	
}
