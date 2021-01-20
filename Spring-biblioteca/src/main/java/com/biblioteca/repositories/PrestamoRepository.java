package com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
	@Query("SELECT p FROM Prestamo p WHERE p.fechaEntregado = null AND p.usuario = :usuario")
	List<Prestamo> prestamosSinEntrega(@Param("usuario") com.biblioteca.model.Usuario Usuario);
}
