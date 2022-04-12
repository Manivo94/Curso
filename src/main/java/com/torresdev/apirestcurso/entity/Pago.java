package com.torresdev.apirestcurso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pago")
public class Pago {
	
	//Declaracion de variabes
	@Id  // Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Es Autoincrementable
	private long id;
	@Column(name = "forma")
	private String forma;
	
	//Creacion de constructores
	public Pago() {}

	public Pago(long id, String forma) {
		this.id = id;
		this.forma = forma;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", forma=" + forma + "]";
	}
	
	

}
