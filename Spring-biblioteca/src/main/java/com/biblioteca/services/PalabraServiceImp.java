package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.PalabraClave;
import com.biblioteca.repositories.PalabrasRepository;

@Service
public class PalabraServiceImp implements IPalabraService {
	
	@Autowired
	private PalabrasRepository pr;

	@Override
	public PalabraClave crearPalabraClave(PalabraClave p) {
		return pr.save(p);
	}

	@Override
	public PalabraClave actualizarPalabraClave(PalabraClave p) {
		return pr.save(p);
	}

	@Override
	public void eliminarPalabraClave(Long id) {
		pr.deleteById(id);
	}

	@Override
	public List<PalabraClave> listarTodasPalabras() {
		return pr.findAll();
	}

	@Override
	public Optional<PalabraClave> buscarPalabraId(Long id) {
		return pr.findById(id);
	}

}
