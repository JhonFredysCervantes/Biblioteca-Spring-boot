package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Editorial;
import com.biblioteca.repositories.EditorialRepository;

@Service
public class EditorialServiceImp implements IEditorialService {
	
	@Autowired
	private EditorialRepository er;

	@Override
	public Editorial crearEditorial(Editorial e) {

		return er.save(e);
	}

	@Override
	public Editorial actualizarEditorial(Editorial e) {

		return er.save(e);
	}

	@Override
	public void eliminarEditorial(Long id) {
		er.deleteById(id);
	}

	@Override
	public List<Editorial> listarEditoriales() {
		return er.findAll();
	}

	@Override
	public Optional<Editorial> buscarEditorialId(Long id) {
		return er.findById(id);
	}

}
