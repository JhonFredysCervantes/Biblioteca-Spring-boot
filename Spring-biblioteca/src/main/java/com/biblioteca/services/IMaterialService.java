package com.biblioteca.services;

import java.util.List;


import com.biblioteca.model.Material;

public interface IMaterialService {

	Material crearMaterial(Material m);
	Material actualizarMaterial(Material m); 
	boolean eliminarMaterial(Material m);
	List<Material> listarTodosAutores();
}
