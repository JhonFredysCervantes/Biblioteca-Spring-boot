package com.biblioteca.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="sedes")
public class Sede {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sede;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column
	private Long telefono;
	
	@Column(nullable = false)
	private String direccion;
	
	@OneToMany(mappedBy = "sede")
	private Set<Prestamo> prestamos;
	
	@OneToMany(mappedBy = "sedes")
	List<SedeLibro> materiales;
	
	protected Sede() {super();}

	public Sede(String nombre, Long telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	public Sede(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Long getId_sede() {
		return id_sede;
	}

	public void setId_sede(Long id_sede) {
		this.id_sede = id_sede;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<SedeLibro> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<SedeLibro> materiales) {
		this.materiales = materiales;
	}
	
	

}
