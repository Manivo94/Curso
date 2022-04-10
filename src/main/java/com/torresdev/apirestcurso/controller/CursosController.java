package com.torresdev.apirestcurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torresdev.apirestcurso.entity.Cursos;
import com.torresdev.apirestcurso.repository.CursosRepository;

@RestController
@RequestMapping("/api")
public class CursosController {
	
	// Inyeccion de Dependencias
	@Autowired
	CursosRepository cursoRepository;
	
	
	//Metodo de tipo Post
	@PostMapping("/cursos")
	public ResponseEntity<Cursos> CrearCurso(@RequestBody Cursos cursos){
		try {
			Cursos _cursos = cursoRepository
					.save(new Cursos(cursos.getNombre(), cursos.getDescripcion(), cursos.getCaracteristica(), cursos.getEstaActivo()));
			return new ResponseEntity<>(_cursos, HttpStatus.CREATED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
