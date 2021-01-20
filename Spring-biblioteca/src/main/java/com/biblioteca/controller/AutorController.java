package com.biblioteca.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Autor;
import com.biblioteca.model.Material;
import com.biblioteca.services.IAutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired 
	IAutorService aService;
	
	/*http://localhost:8080/autor/...*/
	
	//CREAR UN AUTOR
	@PostMapping
	public Autor crear(@RequestBody Autor a) {
		return aService.crearAutor(a);
	}
	
	//EDITAR UN AUTOR
	@PutMapping("/{id}")
	public Autor editar(@RequestBody Autor a, @PathVariable("id") Long id) {
		
		if(id!=null) {
			
			Optional<Autor> resultado = aService.buscarAutorId(id);
			
			if(resultado.isPresent()) {
				String cadena;
				Autor oldAutor = resultado.get();
				
				cadena = a.getPrimerNombre();
				oldAutor.setPrimerNombre(cadena);
				
				cadena = a.getSegundoNombre();
				oldAutor.setSegundoNombre(cadena);
				
				cadena = a.getPrimerApellido();
				oldAutor.setPrimerApellido(cadena);
				
				cadena = a.getSegundoApellido();
				oldAutor.setSegundoApellido(cadena);
				
				Character genero = a.getGenero();
				oldAutor.setGenero(genero);
				
				cadena = a.getEmail();
				oldAutor.setEmail(cadena);
				
				Date nacimiento = a.getNacimiento();
				oldAutor.setNacimiento(nacimiento);
				
				Date fallecimiento = a.getFallecimiento();
				oldAutor.setFallecimiento(fallecimiento);
				
				List<Material> autoria = a.getAutoria();
				oldAutor.setAutoria(autoria);
				
				return aService.actualizarAutor(oldAutor);
			}
		}
		
		return null;
		
	}
	
	//ELIMINAR UN AUTOR
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		aService.eliminarAutor(id);
	}
	
	//LISTANDO TODOS LOS AUTORES
	@GetMapping("/listarautores")
	public List<Autor> listarAutores(){
		return aService.listarTodosAutores();
	}
	
	//Falta revisar este metodo
	@GetMapping("/buscarnombre/{firstname}_{lastname}")
	public List<Autor> buscarPorNombre(@PathVariable("firstname") String primerNombre,@PathVariable("lastname") String primerApellido){
		return aService.buscarPrimerNombreYApellido(primerNombre, primerApellido);
	}

}
