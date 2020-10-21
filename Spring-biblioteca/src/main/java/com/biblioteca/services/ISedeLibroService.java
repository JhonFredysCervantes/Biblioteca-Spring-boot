package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.SedeLibro;

public interface ISedeLibroService {

	SedeLibro crearSedeLibro(SedeLibro s);
	SedeLibro actualizarSedeLibro(SedeLibro s); 
	void eliminarSedeLibro(SedeLibro s);
	
	List<SedeLibro> listarSedeLibros();
	SedeLibro buscarSedeLibrosId(Long id);
}
