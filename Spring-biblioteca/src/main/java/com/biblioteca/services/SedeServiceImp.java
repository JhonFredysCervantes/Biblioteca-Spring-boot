package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Sede;
import com.biblioteca.repositories.SedeRepository;

@Service
public class SedeServiceImp implements ISedeService {
	
	@Autowired
	private SedeRepository sr;

	@Override
	public Sede crearSede(Sede s) {
		return sr.save(s);
	}

	@Override
	public Sede actualizarSede(Sede s) {
		return sr.save(s);
	}

	@Override
	public void eliminarSede(Long id) {
		sr.deleteById(id);
	}

	@Override
	public List<Sede> listarTodosSedes() {
		return sr.findAll();
	}

	@Override
	public Optional<Sede> buscarSedeId(Long id) {
		return sr.findById(id);
	}

	@Override
	public Sede buscarPorDireccion(String dir) {
		return sr.findByDireccion(dir);
	}

	@Override
	public List<Sede> buscarPorNombre(String nombre) {
		return sr.findByNombre(nombre);
	}

}
