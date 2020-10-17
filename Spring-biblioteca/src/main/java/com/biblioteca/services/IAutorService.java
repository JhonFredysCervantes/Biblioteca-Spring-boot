package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Autor;

public interface IAutorService {

	Autor crearAutor(Autor a);
	Autor actualizarAutor(Autor a); 
	void eliminarAutor(Autor a);
	
	
	List<Autor> listarTodosAutores();
	Autor buscarAutorId(Long id);
}
