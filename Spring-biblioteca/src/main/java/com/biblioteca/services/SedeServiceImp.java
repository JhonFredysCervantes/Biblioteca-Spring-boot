package com.biblioteca.services;

import java.util.List;

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
	public void eliminarSede(Sede s) {
		sr.delete(s);
	}

	@Override
	public List<Sede> listarTodosSedes() {
		return sr.findAll();
	}

	@Override
	public Sede buscarSedeId(Long id) {
		return sr.getOne(id);
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
