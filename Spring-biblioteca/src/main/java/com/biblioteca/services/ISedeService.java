package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Sede;

public interface ISedeService {

	Sede crearSede(Sede s);
	Sede actualizarSede(Sede s); 
	boolean eliminarSede(Sede s);
	List<Sede> listarTodosSedes();
}
