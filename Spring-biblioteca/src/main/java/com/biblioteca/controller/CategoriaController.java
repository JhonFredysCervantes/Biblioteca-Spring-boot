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


import com.biblioteca.model.Categoria;
import com.biblioteca.model.Material;
import com.biblioteca.services.ICategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired 
	private ICategoriaService cService;
	
	/*http://localhost:8080/categoria/...*/
	
	//CREAR UNA CATEGORIA
	@PostMapping
	public Categoria crear(@RequestBody Categoria c) {
		return cService.crearCategoria(c);
	}
	
	//EDITAR UNA CATEGORIA
	@PutMapping("/{id}")
	public Categoria editar(@RequestBody Categoria c, @PathVariable("id") Long id) {
		
		if(id!=null) {
			
			Optional<Categoria> resultado =  cService.buscarCategoriaId(id);
			
			if(resultado.isPresent()) {
				Categoria oldCategoria = resultado.get();
				
				String nombre_categoria = c.getNombreCategoria();
				oldCategoria.setNombreCategoria(nombre_categoria);
				
				Set<Material> materiales = c.getMateriales();
				oldCategoria.setMateriales(materiales);
				
				return cService.actualizarCategoria(oldCategoria);
			}
			
		}
		return null;
	}
	
	//OBTENER UNA CATEGORIA
	@GetMapping("/{id}")
	public Categoria buscar(@PathVariable("id")Long id) {
		if(id!=null) {
			Optional<Categoria> resultado = cService.buscarCategoriaId(id);
			if(resultado.isPresent()) {
				return resultado.get();
			}
		}
		
		return null;
	}
	
	//LISTANDO TODAS LAS CATEGORIAS
	@GetMapping
	public List<Categoria> listarCategorias(){
		return cService.listarTodasCategorias();
	}
	
	//ELIMINAR UNA CATEGORIA
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		cService.eliminarCategoria(id);
	}
	
	
}
