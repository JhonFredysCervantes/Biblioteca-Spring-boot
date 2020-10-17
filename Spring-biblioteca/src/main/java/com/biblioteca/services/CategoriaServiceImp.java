package com.biblioteca.services;

import java.util.List;

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
	public void eliminarCategoria(Categoria c) {
		cr.delete(c);
	}

	@Override
	public Categoria buscarCategoriaId(Long id) {
		return cr.getOne(id);
	}

	@Override
	public List<Categoria> listarTodasCategorias() {
		return cr.findAll();
	}

}
