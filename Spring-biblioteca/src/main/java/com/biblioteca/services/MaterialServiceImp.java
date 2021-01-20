package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Material;
import com.biblioteca.repositories.MaterialRepository;

@Service
public class MaterialServiceImp implements IMaterialService {
	
	@Autowired
	private MaterialRepository mr;

	@Override
	public Material crearMaterial(Material m) {
		return mr.save(m);
	}

	@Override
	public Material actualizarMaterial(Material m) {
		return mr.save(m);
	}

	@Override
	public void eliminarMaterial(Long id) {
		mr.deleteById(id);
	}

	@Override
	public List<Material> listarTodosAutores() {
		return mr.findAll();
	}

	@Override
	public Optional<Material> buscarMaterialId(Long id) {
		return mr.findById(id);
	}

}
