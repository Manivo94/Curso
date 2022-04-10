package com.torresdev.apirestcurso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Cursos {
	
	// Declaracion de Atributos
	
	@Id  // Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Es Autoincrementable
	private long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "caracteristicas")
	private String caracteristica;
	@Column(name = "estaActivo")
	private Boolean estaActivo;
	
	
	// Construir los constructores
	public Cursos() {   }
	
	public Cursos(long id, String nombre, String descripcion, String caracteristica, Boolean estaActivo) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.caracteristica = caracteristica;
		this.estaActivo = estaActivo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Boolean getEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(Boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	@Override
	public String toString() {
		return "Cursos [id: =" + id + ", nombre: =" + nombre + ", descripcion: =" + descripcion + ", caracteristica: ="
				+ caracteristica + ", estaActivo: =" + estaActivo + "]";
	}
	
	
	
	
	
	

}
