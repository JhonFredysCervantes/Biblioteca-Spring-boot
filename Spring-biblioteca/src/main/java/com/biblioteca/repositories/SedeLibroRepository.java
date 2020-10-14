package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.SedeLibro;

@Repository
public interface SedeLibroRepository extends JpaRepository<SedeLibro, Long> {

}
