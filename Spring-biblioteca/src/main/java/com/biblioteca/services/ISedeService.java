package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Sede;

public interface ISedeService {

	Sede crearSede(Sede s);
	Sede actualizarSede(Sede s); 
	void eliminarSede(Sede s);
	
	List<Sede> listarTodosSedes();
	Sede buscarSedeId(Long id);
	Sede buscarPorDireccion(String dir);
	List<Sede> buscarPorNombre(String nombre);
}
