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


import com.biblioteca.model.Editorial;
import com.biblioteca.model.Material;
import com.biblioteca.services.IEditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

	@Autowired 
	IEditorialService eService;
	
	/*http://localhost:8080/editorial/...*/
	
	//CREAR UNA EDITORIAL
	@PostMapping
	public Editorial crear(@RequestBody Editorial e) {
		return eService.crearEditorial(e);
	}
	
	//EDITAR UNA EDITORIAL
	@PutMapping("/{id}")
	public Editorial editar(@RequestBody Editorial e, @PathVariable("id") Long id) {
		
		if(id!=null) {
			
			Optional<Editorial> resultado = eService.buscarEditorialId(id);
			
			if(resultado.isPresent()) {
				String cadena;
				Editorial oldEditorial = resultado.get();
						
				cadena = e.getNombreEditorial();
				oldEditorial.setNombreEditorial(cadena);
				
				cadena = e.getSitioWeb();
				oldEditorial.setSitioWeb(cadena);
				
				cadena = e.getEmail();
				oldEditorial.setEmail(cadena);
				
				Set<Material> materiales = e.getMateriales();
				oldEditorial.setMateriales(materiales);
				
				return eService.actualizarEditorial(oldEditorial);
			}
		}
		
		return null;
	}
	
	//ELIMINAR UNA EDITORIAL
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		eService.eliminarEditorial(id);
	}
	
	//LISTANDO TODAS LAS EDITORIALES
	@GetMapping
	public List<Editorial> listaEditoriales(){
		return eService.listarEditoriales();
	}
	
	
}
