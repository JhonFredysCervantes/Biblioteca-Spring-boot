package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

	Material findBytitulo(String titulo);
}
