package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Prestamo;

public interface IPrestamoService {

	Prestamo crearPrestamo(Prestamo p);
	Prestamo actualizarPrestamo(Prestamo p);
	
	List<Prestamo> listarTodosPrestamo();
	Prestamo buscarPrestamoId(Long id);
	
	//List<Prestamo listarPrestamosPorUsuario(Usuario u);
}
