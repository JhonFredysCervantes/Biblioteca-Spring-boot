package com.biblioteca.controller;

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

import com.biblioteca.model.Material;
import com.biblioteca.model.PalabraClave;
import com.biblioteca.services.IPalabraService;

@RestController
@RequestMapping("/palabra")
public class PalabraController {

	@Autowired 
	IPalabraService pService;
	
	/*http://localhost:8080/palabra/...*/
	
	//CREAR UNA PALABRA
	@PostMapping
	public PalabraClave crear(@RequestBody PalabraClave p) {
		return pService.crearPalabraClave(p);
	}
	
	//EDITAR UNA PALABRA
	@PutMapping("/{id}")
	public PalabraClave editar(@RequestBody PalabraClave p, @PathVariable("id") Long id) {
		
		if(id!=null) {
			Optional<PalabraClave> resultado = pService.buscarPalabraId(id);
			
			if(resultado.isPresent()) {
				PalabraClave oldPalabra = resultado.get();
						
				String palabra = p.getPalabra();
				oldPalabra.setPalabra(palabra);
				List<Material> materiales = p.getMateriales();
				oldPalabra.setMateriales(materiales);
				
				
				return pService.actualizarPalabraClave(oldPalabra);
			}
		}
		
		return null;
		
	}
	
	//ELIMINAR UNA PALABRA
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		pService.eliminarPalabraClave(id);
	}
	
	//LISTANDO TODAS LAS PALABRAS
	@GetMapping
	public List<PalabraClave> listarPalabras(){
		return pService.listarTodasPalabras();
	}
	
	
}
