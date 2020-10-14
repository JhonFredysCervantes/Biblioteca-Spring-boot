package com.biblioteca.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name="materiales")
public class Material {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_material;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column
	private String descripcion;
	
	@Column
	private String idioma;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaPublicacion;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_editorial")
	private Editorial ed;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_categoria")
	private Categoria ct;
	
	@OneToMany(mappedBy = "materiales")
	private Set<Prestamo> prestamos;
	
	@OneToMany(mappedBy = "libros")
	List<SedeLibro> sedes;
	
	@ManyToMany
	@JoinTable(name="AutorMaterial",
	joinColumns= @JoinColumn( name="material_id", referencedColumnName="id_material"), 
	inverseJoinColumns=@JoinColumn( name="autor_id", referencedColumnName="id_autor"))
	private List<Autor> autores;
	
	protected Material() {super();}

	public Material(String titulo, String descripcion, String idioma, Date fechaPublicacion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.idioma = idioma;
		this.fechaPublicacion = fechaPublicacion;
	}

	public Material(String titulo, Date fechaPublicacion) {
		super();
		this.titulo = titulo;
		this.fechaPublicacion = fechaPublicacion;
	}
	
	
}
