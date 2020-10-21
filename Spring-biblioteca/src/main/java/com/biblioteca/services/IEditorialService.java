package com.biblioteca.services;

import java.util.List;


import com.biblioteca.model.Editorial;

public interface IEditorialService {

	Editorial crearEditorial(Editorial e);
	Editorial actualizarEditorial(Editorial e); 
	void  eliminarEditorial(Editorial e);
	
	List<Editorial> listarEditoriales();
	Editorial buscarEditorialId(Long id);
}
