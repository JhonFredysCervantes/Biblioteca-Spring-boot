package com.biblioteca.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column(nullable = false, unique = true)
	private String cc;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String contrasena;
	
	@Column(nullable = false)
	private String primerNombre;
	
	@Column
	private String segundoNombre;
	
	@Column(nullable = false)
	private String primerApellido;
	
	@Column
	private String segundoApellido;
	
	@Column
	private Character genero;
	
	@Column(nullable = false)
	private Long telefono;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nacimiento;
	
	@Column(nullable = false)
	private String direccionResidencia;
	
	@OneToMany(mappedBy = "usuario")
	private Set<Prestamo> prestamo;
	
	protected Usuario() {super();}

	public Usuario(String cc, String email, String contrasena, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, Character genero, Long telefono, Date nacimiento,
			String direccionResidencia) {
		super();
		this.cc = cc;
		this.email = email;
		this.contrasena = contrasena;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.genero = genero;
		this.telefono = telefono;
		this.nacimiento = nacimiento;
		this.direccionResidencia = direccionResidencia;
	}

	public Usuario(String cc, String email, String contrasena, String primerNombre, String primerApellido,
			Long telefono, String direccionResidencia) {
		super();
		this.cc = cc;
		this.email = email;
		this.contrasena = contrasena;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.telefono = telefono;
		this.direccionResidencia = direccionResidencia;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

	public Set<Prestamo> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Set<Prestamo> prestamo) {
		this.prestamo = prestamo;
	}
	
	

}
