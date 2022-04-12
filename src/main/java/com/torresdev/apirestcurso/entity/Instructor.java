package com.torresdev.apirestcurso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	// Declaracion de Atributos
	
		@Id  // Id
		@GeneratedValue(strategy = GenerationType.AUTO) // Es Autoincrementable
		private long id;
		@Column(name = "nombre")
		private String nombre;
		@Column (name = "apellidos")
		private String apellidos;
		@Column (name = "edad")
		private int edad;
		@Column(name = "sexo")
		private String sexo;
		@Column(name = "correo")
		private String correo;
		@Column(name = "telefono")
		private long telefono;

		//Creacion de constructores
		public Instructor() {}

		public Instructor(long id, String nombre, String apellidos, int edad, String sexo, String correo, long telefono) {
			this.id = id;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.edad = edad;
			this.sexo = sexo;
			this.correo = correo;
			this.telefono = telefono;
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

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public long getTelefono() {
			return telefono;
		}

		public void setTelefono(long telefono) {
			this.telefono = telefono;
		}

		@Override
		public String toString() {
			return "Instructor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
					+ ", sexo=" + sexo + ", correo=" + correo + ", telefono=" + telefono + "]";
		}
		
		
}
