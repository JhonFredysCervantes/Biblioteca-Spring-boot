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
import com.biblioteca.model.PalabraClave;
import com.biblioteca.services.IPalabraService;

@RestController
@RequestMapping("/palabra")
public class PalabraController {

	@Autowired 
	IPalabraService pService;
	
	/*http://localhost:8080/palabra/...*/
	
	//CREAR UNA PALABRA
	@PostMapping("/crear")
	public PalabraClave crear(@RequestBody PalabraClave p) {
		return pService.crearPalabraClave(p);
	}
	
	//EDITAR UNA PALABRA
	@PutMapping("/editar/{id}")
	public PalabraClave editar(@RequestBody PalabraClave p, @PathVariable("id") Long id) {
		PalabraClave oldPalabra = pService.buscarPalabraId(id);
		
		String palabra = p.getPalabra();
		oldPalabra.setPalabra(palabra);
		
		return pService.actualizarPalabraClave(oldPalabra);
	}
	
	//ELIMINAR UNA PALABRA
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		PalabraClave p = pService.buscarPalabraId(id);
		pService.eliminarPalabraClave(p);
	}
	
	//LISTANDO TODAS LAS PALABRAS
	@GetMapping("/listarpalabras")
	public List<PalabraClave> listarPalabras(){
		return pService.listarTodasPalabras();
	}
	
	
}
