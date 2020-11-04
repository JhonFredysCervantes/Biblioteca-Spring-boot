package com.biblioteca.controller;

import java.util.Date;
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

import com.biblioteca.model.Autor;
import com.biblioteca.model.Categoria;
import com.biblioteca.model.Editorial;
import com.biblioteca.model.Material;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.SedeLibro;
import com.biblioteca.services.IMaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {

	@Autowired 
	IMaterialService mService;
	
	/*http://localhost:8080/material/...*/
	
	//CREAR UN MATERIAL
	@PostMapping("/crear")
	public Material crear(@RequestBody Material m) {
		return mService.crearMaterial(m);
	}
	
	//EDITAR UN MATERIAL
	@PutMapping("/editar/{id}")
	public Material editar(@RequestBody Material m, @PathVariable("id") Long id) {
		Material oldMaterial = mService.buscarMaterialId(id);
		
		String titulo = m.getTitulo();
		oldMaterial.setTitulo(titulo);
		
		String descripcion = m.getDescripcion();
		oldMaterial.setDescripcion(descripcion);
		
		String idioma = m.getIdioma();
		oldMaterial.setIdioma(idioma);
		
		Date fechaPublicacion = m.getFechaPublicacion();
		oldMaterial.setFechaPublicacion(fechaPublicacion);
		
		Editorial editorial = m.getEd();
		oldMaterial.setEd(editorial);
		
		Categoria categoria = m.getCt();
		oldMaterial.setCt(categoria);
		
		Set<Prestamo> prestamos = m.getPrestamos();
		oldMaterial.setPrestamos(prestamos);
		
		List<SedeLibro> sedes = m.getSedes();
		oldMaterial.setSedes(sedes);
		
		List<Autor> autores = m.getAutores();
		oldMaterial.setAutores(autores);
		
		return mService.actualizarMaterial(oldMaterial);
	}
	
	//ELIMINAR UN MATERIAL
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		Material m = mService.buscarMaterialId(id);
		mService.eliminarMaterial(m);
	}
	
	//LISTANDO TODOS LOS MATERIALEs
	@GetMapping("/listarmateriales")
	public List<Material> listarMateriales(){
		return mService.listarTodosAutores();
	}
	
	
}
