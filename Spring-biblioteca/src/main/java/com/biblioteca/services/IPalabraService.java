package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.PalabraClave;

public interface IPalabraService {

	PalabraClave crearPalabraClave(PalabraClave p);
	PalabraClave actualizarPalabraClave(PalabraClave p);
	Optional<PalabraClave> buscarPalabraId(Long id);
	List<PalabraClave> listarTodasPalabras();
	void eliminarPalabraClave(Long id);
}
