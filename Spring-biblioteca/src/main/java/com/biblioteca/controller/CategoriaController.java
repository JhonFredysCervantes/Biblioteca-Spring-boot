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


import com.biblioteca.model.Categoria;
import com.biblioteca.model.Material;
import com.biblioteca.services.ICategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired 
	ICategoriaService cService;
	
	//CREAR UNA CATEGORIA
	@PostMapping("/crear")
	public Categoria crear(@RequestBody Categoria c) {
		return cService.crearCategoria(c);
	}
	
	//EDITAR UNA CATEGORIA
	@PutMapping("/editar/{id}")
	public Categoria editar(@RequestBody Categoria c, @PathVariable("id") Long id) {
		Categoria oldCategoria = cService.buscarCategoriaId(id);
		
		String nombre_categoria = c.getNombreCategoria();
		oldCategoria.setNombreCategoria(nombre_categoria);
		
		Set<Material> materiales = c.getMateriales();
		oldCategoria.setMateriales(materiales);
		
		return cService.actualizarCategoria(oldCategoria);
	}
	
	//ELIMINAR UNA CATEGORIA
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		Categoria c = cService.buscarCategoriaId(id);
		cService.eliminarCategoria(c);
	}
	
	//LISTANDO TODAS LAS CATEGORIAS
	@GetMapping("/listarcategorias")
	public List<Categoria> listarCategorias(){
		return cService.listarTodasCategorias();
	}
	
	
}
