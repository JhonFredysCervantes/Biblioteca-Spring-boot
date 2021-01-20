package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.Sede;

public interface ISedeService {

	Sede crearSede(Sede s);
	Sede actualizarSede(Sede s); 
	Optional<Sede> buscarSedeId(Long id);
	Sede buscarPorDireccion(String dir);
	List<Sede> listarTodosSedes();
	List<Sede> buscarPorNombre(String nombre);
	void eliminarSede(Long id);
}
