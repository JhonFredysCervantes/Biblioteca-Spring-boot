package com.biblioteca.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name="palabrasclaves")
public class PalabraClave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_palabra;
	
	@ManyToMany(mappedBy = "palabras")
	@JsonIgnoreProperties({"palabras"})
	private List<Material> materiales;
	
	@Column(nullable = false)
	private String palabra;
	
	protected PalabraClave() {super();}
	
	public PalabraClave(String palabra) {
		this.palabra = palabra;
	}

	public Long getId_palabra() {
		return id_palabra;
	}

	public void setId_palabra(Long id_palabra) {
		this.id_palabra = id_palabra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}
	
	
	
	
}
