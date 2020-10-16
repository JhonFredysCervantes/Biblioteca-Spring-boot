package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Categoria;

public interface ICategoriaService {

	Categoria crearCategoria(Categoria c);
	Categoria actualizarCategoria(Categoria c); 
	boolean eliminarCategoria(Categoria c);
	List<Categoria> listarTodasCategorias();
}
