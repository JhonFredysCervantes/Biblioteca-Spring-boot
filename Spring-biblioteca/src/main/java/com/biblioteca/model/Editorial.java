package com.biblioteca.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="editoriales")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_editorial;
	
	@Column(nullable = false)
	private String nombreEditorial;
	
	@Column
	private String sitioWeb;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy = "ed", cascade = CascadeType.ALL)
	private Set<Material> materiales;
	
	protected Editorial() {super();}

	public Editorial(String nombreEditorial, String sitioWeb, String email) {
		super();
		this.nombreEditorial = nombreEditorial;
		this.sitioWeb = sitioWeb;
		this.email = email;
	}
	
	public Editorial(String nombreEditorial) {
		super();
		this.nombreEditorial = nombreEditorial;
	}

	public Long getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(Long id_editorial) {
		this.id_editorial = id_editorial;
	}

	public String getNombreEditorial() {
		return nombreEditorial;
	}

	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(Set<Material> materiales) {
		this.materiales = materiales;
	}
	
	
}
