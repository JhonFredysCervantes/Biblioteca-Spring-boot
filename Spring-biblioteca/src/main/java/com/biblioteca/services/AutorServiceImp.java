package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Autor;
import com.biblioteca.repositories.AutorRepository;

@Service
public class AutorServiceImp implements IAutorService {
	
	@Autowired
	
	private AutorRepository ar;
	
	@Override
	public Autor crearAutor(Autor a) {
		return ar.save(a);
	}

	@Override
	public Autor actualizarAutor(Autor a) {
		return ar.save(a);
	}

	@Override
	public void eliminarAutor(Autor a) {
		ar.delete(a);
	}

	@Override
	public List<Autor> listarTodosAutores() {
		return ar.findAll();
	}
	
	@Override
	public Autor buscarAutorId(Long id) {
		return ar.getOne(id);
	}

}
