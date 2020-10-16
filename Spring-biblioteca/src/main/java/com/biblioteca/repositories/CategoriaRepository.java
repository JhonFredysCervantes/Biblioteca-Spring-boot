package com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Categoria findByNombreCategoria(String nombreCategoria);
	
	@Query("SELECT c FROM Categoria c WHERE c.nombreCategoria LIKE %:patron%")
	List<Categoria> findByPatternName(@Param("patron") String patronPrimerNombre);
	

}
