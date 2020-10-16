package com.biblioteca.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name="autores")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_autor;
	
	@Column(nullable = false)
	private String primerNombre;
	
	@Column
	private String segundoNombre;
	
	// Comentarioooooooooooooooo 
	
	@Column(nullable = false)
	private String primerApellido;
	
	@Column
	private String segundoApellido;
	
	@Column
	private Character genero;
	
	@Column(nullable = false)
	private String email;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nacimiento;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fallecimiento;
	
	@ManyToMany(mappedBy = "autores")
	private List<Material> autoria;
	
	protected Autor() {super();}

	public Autor(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			Character genero, String email, Date nacimiento, Date fallecimiento) {
		super();
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.genero = genero;
		this.email = email;
		this.nacimiento = nacimiento;
		this.fallecimiento = fallecimiento;
	}

	public Autor(String primerNombre, String primerApellido) {
		super();
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
	}

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Date getFallecimiento() {
		return fallecimiento;
	}

	public void setFallecimiento(Date fallecimiento) {
		this.fallecimiento = fallecimiento;
	}

	public List<Material> getAutoria() {
		return autoria;
	}

	public void setAutoria(List<Material> autoria) {
		this.autoria = autoria;
	}
	
	
	
}
