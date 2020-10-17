package com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {
	
	Sede findByDireccion(String direccion);
	List<Sede> findByNombre(String nombre);
	
	
}
