package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
