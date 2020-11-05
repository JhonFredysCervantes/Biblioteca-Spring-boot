package com.biblioteca.controller;

import java.util.Date;
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
	@PostMapping("/crear")
	public Autor crear(@RequestBody Autor a) {
		return aService.crearAutor(a);
	}
	
	//EDITAR UN AUTOR
	@PutMapping("/editar/{id}")
	public Autor editar(@RequestBody Autor a, @PathVariable("id") Long id) {
		Autor oldAutor = aService.buscarAutorId(id);
		
		String primer_nombre = a.getPrimerNombre();
		oldAutor.setPrimerNombre(primer_nombre);
		
		String segundo_nombre = a.getSegundoNombre();
		oldAutor.setSegundoNombre(segundo_nombre);
		
		String primer_apellido = a.getPrimerApellido();
		oldAutor.setPrimerApellido(primer_apellido);
		
		String segundo_apellido = a.getSegundoApellido();
		oldAutor.setSegundoApellido(segundo_apellido);
		
		Character genero = a.getGenero();
		oldAutor.setGenero(genero);
		
		String email = a.getEmail();
		oldAutor.setEmail(email);
		
		Date nacimiento = a.getNacimiento();
		oldAutor.setNacimiento(nacimiento);
		
		Date fallecimiento = a.getFallecimiento();
		oldAutor.setFallecimiento(fallecimiento);
		
		List<Material> autoria = a.getAutoria();
		oldAutor.setAutoria(autoria);
		
		return aService.actualizarAutor(oldAutor);
	}
	
	//ELIMINAR UN AUTOR
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		Autor a = aService.buscarAutorId(id);
		aService.eliminarAutor(a);
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
