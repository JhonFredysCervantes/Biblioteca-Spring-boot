package com.biblioteca.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.biblioteca.model.Material;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Sede;
import com.biblioteca.model.Usuario;
import com.biblioteca.services.IPrestamoService;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

	@Autowired 
	IPrestamoService prService;
	
	/*http://localhost:8080/prestamo/...*/
	
	//CREAR UN PRESTAMO
	@PostMapping("/crear")
	public Prestamo crear(@RequestBody Prestamo p) {
		return prService.crearPrestamo(p);
	}
	
	//EDITAR UN PRESTAMO
	@PutMapping("/editar/{id}")
	public Prestamo editar(@RequestBody Prestamo p, @PathVariable("id") Long id) {
		Prestamo oldPrestamo = prService.buscarPrestamoId(id);
		
		Date fechaPrestamo = p.getFechaPrestamo();
		oldPrestamo.setFechaPrestamo(fechaPrestamo);
		
		Date fechaEntregar = p.getFechaEntregar();
		oldPrestamo.setFechaEntregar(fechaEntregar);

		Date fechaEntregado = p.getFechaEntregado();
		oldPrestamo.setFechaEntregado(fechaEntregado);
		
		Sede sede = p.getSede();
		oldPrestamo.setSede(sede);
		
		Material materiales = p.getMateriales();
		oldPrestamo.setMateriales(materiales);
		
		Usuario usuario = p.getUsuario();
		oldPrestamo.setUsuario(usuario);
		
		return prService.actualizarPrestamo(oldPrestamo);
	}
	
	//No se implementa el eliminar, para tener registro de todos los prestamos
	
	//LISTANDO TODOS LOS PRESTAMOS
	@GetMapping("/listarmateriales")
	public List<Prestamo> listarPrestamos(){
		return prService.listarTodosPrestamo();
	}
	
	
}

