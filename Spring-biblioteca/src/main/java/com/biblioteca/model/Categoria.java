package com.biblioteca.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name="categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_categoria;
	
	@Column(nullable = false, unique = true)
	private String nombreCategoria;
	
	@OneToMany(mappedBy = "ct")
	@JsonIgnoreProperties({"ct"})
	private Set<Material> materiales;
	
	protected Categoria() {super();}
	
	public Categoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Set<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(Set<Material> materiales) {
		this.materiales = materiales;
	}
	
	
}
