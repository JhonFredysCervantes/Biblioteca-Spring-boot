package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.Material;

public interface IMaterialService {

	Material crearMaterial(Material m);
	Material actualizarMaterial(Material m); 
	Optional<Material> buscarMaterialId(Long id);
	List<Material> listarTodosAutores();
	void eliminarMaterial(Long id);
}
