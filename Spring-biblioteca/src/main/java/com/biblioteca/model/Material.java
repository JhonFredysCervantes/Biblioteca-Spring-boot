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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name="materiales")
@JsonIgnoreProperties({"prestamos"})
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
	@JsonIgnoreProperties({"materiales"})
	private Editorial ed;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id_categoria")
	@JsonIgnoreProperties({"materiales"})
	private Categoria ct;
	
	@OneToMany(mappedBy = "materiales")
	private Set<Prestamo> prestamos;
	
	@OneToMany(mappedBy = "libros")
	@JsonIgnoreProperties({"libros"})
	List<SedeLibro> sedes;
	
	@ManyToMany
	@JoinTable(name="AutorMaterial",
	joinColumns= @JoinColumn( name="material_id", referencedColumnName="id_material"), 
	inverseJoinColumns=@JoinColumn( name="autor_id", referencedColumnName="id_autor"))
	@JsonIgnoreProperties({"autoria"})
	private List<Autor> autores;
	
	/*Relacion con palabra clave*/
	@ManyToMany
	@JoinTable(name="PalabraMaterial",
	joinColumns= @JoinColumn( name="material_id", referencedColumnName="id_material"), 
	inverseJoinColumns=@JoinColumn( name="palabra_id", referencedColumnName="id_palabra"))
	private List<PalabraClave> palabras;
	
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

	public Long getId_material() {
		return id_material;
	}

	public void setId_material(Long id_material) {
		this.id_material = id_material;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Editorial getEd() {
		return ed;
	}

	public void setEd(Editorial ed) {
		this.ed = ed;
	}

	public Categoria getCt() {
		return ct;
	}

	public void setCt(Categoria ct) {
		this.ct = ct;
	}

	public Set<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<SedeLibro> getSedes() {
		return sedes;
	}

	public void setSedes(List<SedeLibro> sedes) {
		this.sedes = sedes;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<PalabraClave> getPalabras() {
		return palabras;
	}

	public void setPalabras(List<PalabraClave> palabras) {
		this.palabras = palabras;
	}
	
	
	
}
