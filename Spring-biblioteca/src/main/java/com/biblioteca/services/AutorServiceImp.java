package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

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
	public void eliminarAutor(Long id) {
		ar.deleteById(id);
	}

	@Override
	public List<Autor> listarTodosAutores() {
		return ar.findAll();
	}
	
	@Override
	public Optional<Autor> buscarAutorId(Long id) {
		return ar.findById(id);
	}

	@Override
	public List<Autor> buscarPrimerNombreYApellido(String primer_nombre, String primer_apellido) {
		return ar.findByPrimerNombreAndPrimerApellido(primer_nombre, primer_apellido);
	}

}
