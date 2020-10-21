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


import com.biblioteca.model.Editorial;
import com.biblioteca.model.Material;
import com.biblioteca.services.IEditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

	@Autowired 
	IEditorialService eService;
	
	//CREAR UNA EDITORIAL
	@PostMapping("/crear")
	public Editorial crear(@RequestBody Editorial e) {
		return eService.crearEditorial(e);
	}
	
	//EDITAR UNA EDITORIAL
	@PutMapping("/editar/{id}")
	public Editorial editar(@RequestBody Editorial e, @PathVariable("id") Long id) {
		Editorial oldEditorial = eService.buscarEditorialId(id);
		
		String nombre_editorial = e.getNombreEditorial();
		oldEditorial.setNombreEditorial(nombre_editorial);
		
		String sitioWeb = e.getSitioWeb();
		oldEditorial.setSitioWeb(sitioWeb);
		
		String email = e.getEmail();
		oldEditorial.setEmail(email);
		
		Set<Material> materiales = e.getMateriales();
		oldEditorial.setMateriales(materiales);
		
		return eService.actualizarEditorial(oldEditorial);
	}
	
	//ELIMINAR UNA EDITORIAL
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		Editorial e = eService.buscarEditorialId(id);
		eService.eliminarEditorial(e);
	}
	
	//LISTANDO TODAS LAS EDITORIALEs
	@GetMapping("/listareditoriales")
	public List<Editorial> listaEditoriales(){
		return eService.listarEditoriales();
	}
	
	
}
