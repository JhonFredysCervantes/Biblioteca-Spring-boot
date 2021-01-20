package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Categoria;
import com.biblioteca.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImp implements ICategoriaService {
	
	@Autowired
	private CategoriaRepository cr;

	@Override
	public Categoria crearCategoria(Categoria c) {
		return cr.save(c);
	}

	@Override
	public Categoria actualizarCategoria(Categoria c) {
		return cr.save(c);
	}

	@Override
	public void eliminarCategoria(Long id) {
		cr.deleteById(id);
	}

	@Override
	public Optional<Categoria> buscarCategoriaId(Long id) {
		return cr.findById(id);
	}

	@Override
	public List<Categoria> listarTodasCategorias() {
		return cr.findAll();
	}

}
