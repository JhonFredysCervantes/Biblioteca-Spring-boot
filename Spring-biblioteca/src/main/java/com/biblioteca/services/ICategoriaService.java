package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.Categoria;

public interface ICategoriaService {

	Categoria crearCategoria(Categoria c);
	Categoria actualizarCategoria(Categoria c); 
	Optional<Categoria> buscarCategoriaId(Long id);
	void eliminarCategoria(Long id);
	List<Categoria> listarTodasCategorias();
}
