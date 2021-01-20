package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.Autor;

public interface IAutorService {

	Autor crearAutor(Autor a);
	Autor actualizarAutor(Autor a); 
	Optional<Autor> buscarAutorId(Long id);
	List<Autor> listarTodosAutores();
	void eliminarAutor(Long id);
	
	List<Autor> buscarPrimerNombreYApellido(String primer_nombre, String primer_apellido);
}
