package com.biblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	@Table(name="prestamos")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prestamo;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaPrestamo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEntregar;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEntregado;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_sede")
	private Sede sede;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_material")
	@JsonIgnoreProperties({"prestamos"})
	private Material materiales;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_usuario")
	@JsonIgnoreProperties({"prestamo"})
	private Usuario usuario;
	
	protected Prestamo() {super();}

	public Prestamo(Date fechaPrestamo, Date fechaEntregar, Sede sede, Material materiales, Usuario usuario) {
		super();
		this.fechaPrestamo = fechaPrestamo;
		this.fechaEntregar = fechaEntregar;
		this.sede = sede;
		this.materiales = materiales;
		this.usuario = usuario;
	}

	public Long getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(Long id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaEntregar() {
		return fechaEntregar;
	}

	public void setFechaEntregar(Date fechaEntregar) {
		this.fechaEntregar = fechaEntregar;
	}

	public Date getFechaEntregado() {
		return fechaEntregado;
	}

	public void setFechaEntregado(Date fechaEntregado) {
		this.fechaEntregado = fechaEntregado;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	

	public Material getMateriales() {
		return materiales;
	}

	public void setMateriales(Material materiales) {
		this.materiales = materiales;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
