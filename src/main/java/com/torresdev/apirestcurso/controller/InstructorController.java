package com.torresdev.apirestcurso.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.torresdev.apirestcurso.entity.Cursos;
import com.torresdev.apirestcurso.entity.Instructor;
import com.torresdev.apirestcurso.repository.InstructorRepository;

@RestController
@RequestMapping("/api")
public class InstructorController {
	
	//Inyeccion de dependencias
	@Autowired
	InstructorRepository instructorRepository;
	
	//Metodo de creacion tipo POST
	@PostMapping("/instructor")
	public ResponseEntity<Instructor> crearInstructor(@RequestBody Instructor instructor){
		try {
			Instructor _instructor = instructorRepository
					.save(new Instructor(instructor.getId(),instructor.getNombre(), instructor.getApellidos(),instructor.getEdad(), instructor.getSexo(), instructor.getCorreo(), instructor.getTelefono()));
			return new ResponseEntity<>(_instructor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Metodo para mostrar de tipo GET
	@GetMapping("/instructor")
	public ResponseEntity<List<Instructor>> mostrarTodos() {
		List<Instructor> instructor = new ArrayList<Instructor>();
		instructorRepository.findAll().forEach(instructor::add);
		if(instructor.isEmpty()) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(instructor, HttpStatus.OK);
		}
	}
	
	// Mostrar por Id
		@GetMapping("/instructor/{id}")
		public ResponseEntity<Instructor> mostrarPorId(@PathVariable("id") long id){
			Optional<Instructor> instructor= instructorRepository.findById(id);
			if(instructor.isPresent()) {
				return new ResponseEntity<>(instructor.get(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		// Metodo Para Actualizar
		@PutMapping("/instructor/{id}")
		public ResponseEntity<Instructor> editarInstructor(@PathVariable("id") long id, @RequestBody Instructor instructor){
			
			Optional<Instructor> instructorLista = instructorRepository.findById(id);
			
			if(instructorLista.isPresent()) {
				Instructor _instructor = instructorLista.get();
				_instructor.setNombre(instructor.getNombre());
				_instructor.setApellidos(instructor.getApellidos());
				_instructor.setEdad(instructor.getEdad());
				_instructor.setSexo(instructor.getSexo());
				_instructor.setCorreo(instructor.getCorreo());
				_instructor.setTelefono(instructor.getTelefono());
				return new ResponseEntity<>(instructorRepository.save(_instructor),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		//Metodo delete para eliminar.
		@DeleteMapping("/instructor/{id}")
		public ResponseEntity<?> eliminarInstructor(@PathVariable("id") long id){
			
			try {
				instructorRepository.deleteById(id); // Ya se elimino
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}catch(Exception e) {
				 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	

}
