package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Prestamo;

public interface IPrestamoService {

	Prestamo crearPrestamo(Prestamo p);
	boolean eliminarPrestamo(Prestamo p);
	List<Prestamo> listarTodosPrestamo();
	//List<Prestamo> listarPrestamosPorUsuario(Usuario u);
}
