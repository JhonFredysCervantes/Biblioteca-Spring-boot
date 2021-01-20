package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Prestamo;
import com.biblioteca.repositories.PrestamoRepository;

@Service
public class PrestamoServiceImp implements IPrestamoService {
	
	@Autowired
	private PrestamoRepository pr;

	@Override
	public Prestamo crearPrestamo(Prestamo p) {
		return pr.save(p);
	}

	@Override
	public Prestamo actualizarPrestamo(Prestamo p) {
		return pr.save(p);
	}

	@Override
	public List<Prestamo> listarTodosPrestamo() {
		return pr.findAll();
	}

	@Override
	public Optional<Prestamo> buscarPrestamoId(Long id) {
		return pr.findById(id);
	}

}
