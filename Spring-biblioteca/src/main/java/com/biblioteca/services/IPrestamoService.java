package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.Prestamo;

public interface IPrestamoService {

	Prestamo crearPrestamo(Prestamo p);
	Prestamo actualizarPrestamo(Prestamo p);
	
	List<Prestamo> listarTodosPrestamo();
	Optional<Prestamo> buscarPrestamoId(Long id);
	
	//List<Prestamo listarPrestamosPorUsuario(Usuario u);
}
