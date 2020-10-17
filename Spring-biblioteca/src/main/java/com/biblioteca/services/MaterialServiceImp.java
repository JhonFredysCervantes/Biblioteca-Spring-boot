package com.biblioteca.services;

import java.util.List;

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
	public void eliminarMaterial(Material m) {
		mr.delete(m);
	}

	@Override
	public List<Material> listarTodosAutores() {
		return mr.findAll();
	}

	@Override
	public Material buscarMaterialId(Long id) {
		return mr.getOne(id);
	}

}
