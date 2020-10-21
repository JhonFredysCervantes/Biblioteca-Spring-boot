package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.SedeLibro;
import com.biblioteca.repositories.SedeLibroRepository;

@Service
public class SedeLibroImp implements ISedeLibroService {

	@Autowired
	SedeLibroRepository slr;
	
	@Override
	public SedeLibro crearSedeLibro(SedeLibro s) {
		return slr.save(s);
	}

	@Override
	public SedeLibro actualizarSedeLibro(SedeLibro s) {
		return slr.save(s);
	}

	@Override
	public void eliminarSedeLibro(SedeLibro s) {
		slr.delete(s);
	}

	@Override
	public List<SedeLibro> listarSedeLibros() {
		return slr.findAll();
	}

	@Override
	public SedeLibro buscarSedeLibrosId(Long id) {
		return slr.getOne(id);
	}

}
