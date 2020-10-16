package com.biblioteca.services;

import java.util.List;


import com.biblioteca.model.PalabraClave;

public interface IPalabraService {

	PalabraClave crearPalabraClave(PalabraClave p);
	PalabraClave actualizarPalabraClave(PalabraClave p); 
	boolean eliminarPalabraClave(PalabraClave p);
	List<PalabraClave> listarTodasPalabras();
}
