package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.SedeLibro;

public interface ISedeLibroService {

	SedeLibro crearSedeLibro(SedeLibro s);
	SedeLibro actualizarSedeLibro(SedeLibro s); 
	Optional<SedeLibro> buscarSedeLibrosId(Long id);
	List<SedeLibro> listarSedeLibros();
	void eliminarSedeLibro(Long id);
}
