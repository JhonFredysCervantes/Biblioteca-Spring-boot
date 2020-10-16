package com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	List<Autor> findByPrimerNombre(String primerNombre);
	
	List<Autor> findByPrimerApellido(String primerApellido);
	
	List<Autor> findByPrimerNombreAndPrimerApellido(String primerNombre, String primerApellido);
	
	@Query("SELECT a FROM Autor a WHERE a.primerNombre LIKE %:patron%")
	List<Autor> findByPatternName(@Param("patron") String patronPrimerNombre);

}
