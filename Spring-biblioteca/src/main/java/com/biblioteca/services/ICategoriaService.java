package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Categoria;

public interface ICategoriaService {

	Categoria crearCategoria(Categoria c);
	Categoria actualizarCategoria(Categoria c); 
	void eliminarCategoria(Categoria c);
	
	Categoria buscarCategoriaId(Long id);
	List<Categoria> listarTodasCategorias();
}
