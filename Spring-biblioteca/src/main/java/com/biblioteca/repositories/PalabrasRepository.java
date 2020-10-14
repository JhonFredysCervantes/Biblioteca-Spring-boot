package com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.PalabraClave;

@Repository
public interface PalabrasRepository extends JpaRepository<PalabraClave, Long> {

}
