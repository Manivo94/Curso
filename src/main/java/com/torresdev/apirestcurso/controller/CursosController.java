package com.torresdev.apirestcurso.controller;

import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.torresdev.apirestcurso.entity.Cursos;
import com.torresdev.apirestcurso.repository.CursosRepository;

@RestController
@RequestMapping("/api")
public class CursosController {
	
	// Inyeccion de Dependencias
	@Autowired
	CursosRepository cursoRepository;
	
	
	//Metodo de tipo Post (Creacion)
	@PostMapping("/cursos")
	public ResponseEntity<Cursos> CrearCurso(@RequestBody Cursos cursos){
		try {
			Cursos _cursos = cursoRepository
					.save(new Cursos(cursos.getId(), cursos.getNombre(), cursos.getDescripcion(), cursos.getCaracteristica(), cursos.getEstaActivo()));
			return new ResponseEntity<>(_cursos, HttpStatus.CREATED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// Metodo para mostrar todos los cursos
	@GetMapping("/cursos")
	public ResponseEntity<List<Cursos>> mostrarTodo(){

		List<Cursos> cursos = new ArrayList<Cursos>();
		cursoRepository.findAll().forEach(cursos::add);
		
		if(cursos.isEmpty()) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(cursos, HttpStatus.OK);
		}
		
		
			
	}

	// Mostrar por Id
	@GetMapping("/cursos/{id}")
	public ResponseEntity<Cursos> mostrarPorId(@PathVariable("id") long id){
		Optional<Cursos> cursos = cursoRepository.findById(id);
		if(cursos.isPresent()) {
			return new ResponseEntity<>(cursos.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Metodo Para Actualizar
	@PutMapping("/cursos/{id}")
	public ResponseEntity<Cursos> editarCurso(@PathVariable("id") long id, @RequestBody Cursos cursos){
		
		Optional<Cursos> cursosLista = cursoRepository.findById(id);
		
		if(cursosLista.isPresent()) {
			Cursos _cursos = cursosLista.get();
			_cursos.setNombre(cursos.getNombre());
			_cursos.setDescripcion(cursos.getDescripcion());
			_cursos.setCaracteristica(cursos.getCaracteristica());
			_cursos.setEstaActivo(cursos.getEstaActivo());
			return new ResponseEntity<>(cursoRepository.save(_cursos),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/cursos/{id}")
	public ResponseEntity<?> eliminarCurso(@PathVariable("id") long id){
		
		try {
			cursoRepository.deleteById(id); // Ya se elimino
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
}
