package com.biblioteca.controller;

import java.util.Date;
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

import com.biblioteca.model.Autor;
import com.biblioteca.model.Categoria;
import com.biblioteca.model.Editorial;
import com.biblioteca.model.Material;
import com.biblioteca.model.PalabraClave;
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
	@PostMapping
	public Material crear(@RequestBody Material m) {
		return mService.crearMaterial(m);
	}
	
	//EDITAR UN MATERIAL
	@PutMapping("/{id}")
	public Material editar(@RequestBody Material m, @PathVariable("id") Long id) {
		
		if(id!=null) {
			Optional<Material> resultado = mService.buscarMaterialId(id);
			
			if(resultado.isPresent()) {
				
				String cadena;
				Material oldMaterial = resultado.get();
						
				cadena = m.getTitulo();
				oldMaterial.setTitulo(cadena);
				
				cadena = m.getDescripcion();
				oldMaterial.setDescripcion(cadena);
				
				cadena = m.getIdioma();
				oldMaterial.setIdioma(cadena);
				
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
				
				List<PalabraClave> palabras = m.getPalabras();
				oldMaterial.setPalabras(palabras);
				
				return mService.actualizarMaterial(oldMaterial);
				
			}
		}
		return null;
	}
	
	//BUSCAR MATERIAL
	@GetMapping("/{id}")
	public Material buscar(@PathVariable("id")Long id) {
		
		if(id!=null) {
			Optional<Material> resultado = mService.buscarMaterialId(id);
			
			if(resultado.isPresent()) {
				return resultado.get();
			}
		}
		
		return null;
	}
	
	//ELIMINAR UN MATERIAL
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		mService.eliminarMaterial(id);
	}
	
	//LISTANDO TODOS LOS MATERIALEs
	@GetMapping
	public List<Material> listarMateriales(){
		return mService.listarTodosAutores();
	}
	
}
