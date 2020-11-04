package com.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	@Table(name = "sede_libros")
public class SedeLibro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sedelibro;
	
	@Column
	private int numejemplares;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_sede")
	@JsonIgnoreProperties({"materiales"})
	private Sede sedes;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_material")
	@JsonIgnoreProperties({"sedes"})
	private Material libros;

	protected SedeLibro() {super();}

	public SedeLibro(int numejemplares, Sede sedes, Material libros) {
		super();
		this.numejemplares = numejemplares;
		this.sedes = sedes;
		this.libros = libros;
	}

	public Long getId_sedelibro() {
		return id_sedelibro;
	}

	public void setId_sedelibro(Long id_sedelibro) {
		this.id_sedelibro = id_sedelibro;
	}

	public int getNumejemplares() {
		return numejemplares;
	}

	public void setNumejemplares(int numejemplares) {
		this.numejemplares = numejemplares;
	}

	public Sede getSedes() {
		return sedes;
	}

	public void setSedes(Sede sedes) {
		this.sedes = sedes;
	}

	public Material getLibros() {
		return libros;
	}

	public void setLibros(Material libros) {
		this.libros = libros;
	}
	
	
	
}
