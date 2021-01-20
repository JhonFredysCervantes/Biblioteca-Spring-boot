package com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByCc(String cc);
	
	Usuario findByEmail(String email);
	
	List<Usuario> findByPrimerNombreAndPrimerApellido(String primerNombre, String primerApellido);
	
	@Query("SELECT COUNT(u.id) FROM Usuario u")
	int countUsers();
	
	
}
