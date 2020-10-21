package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Material;
import com.biblioteca.model.Sede;
import com.biblioteca.model.SedeLibro;
import com.biblioteca.services.ISedeLibroService;

@RestController
@RequestMapping("/sedelibro")
public class SedeLibroController {

	@Autowired 
	ISedeLibroService slService;
	
	//CREAR UNA SEDE
	@PostMapping("/crear")
	public SedeLibro crear(@RequestBody SedeLibro s) {
		return slService.crearSedeLibro(s);
	}
	
	//EDITAR UNA SEDE
	@PutMapping("/editar/{id}")
	public SedeLibro editar(@RequestBody SedeLibro s, @PathVariable("id") Long id) {
		SedeLibro oldSede = slService.buscarSedeLibrosId(id);
		
		int numeroejemplares = s.getNumejemplares();
		oldSede.setNumejemplares(numeroejemplares);
		
		Sede sedes = s.getSedes();
		oldSede.setSedes(sedes);
		
		Material libros = s.getLibros();
		oldSede.setLibros(libros);
		
		return slService.actualizarSedeLibro(oldSede);
	}
	
	//ELIMINAR UNA SEDE
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		SedeLibro s = slService.buscarSedeLibrosId(id);
		slService.eliminarSedeLibro(s);
	}
	
	//LISTANDO TODAS LAS SEDES
	@GetMapping("/listarsedes")
	public List<SedeLibro> listarSedes(){
		return slService.listarSedeLibros();
	}
	
	
}
