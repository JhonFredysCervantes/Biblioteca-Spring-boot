package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.Editorial;

public interface IEditorialService {

	Editorial crearEditorial(Editorial e);
	Editorial actualizarEditorial(Editorial e); 
	Optional<Editorial> buscarEditorialId(Long id);
	List<Editorial> listarEditoriales();
	void  eliminarEditorial(Long id);
}
