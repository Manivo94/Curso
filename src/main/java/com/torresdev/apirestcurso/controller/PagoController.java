package com.torresdev.apirestcurso.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.torresdev.apirestcurso.entity.Cursos;
import com.torresdev.apirestcurso.entity.Pago;
import com.torresdev.apirestcurso.repository.PagoRepository;

@RestController
@RequestMapping("/api")
public class PagoController {
	
	// Inyeccion de Dependencias
	@Autowired
	PagoRepository pagoRepository;
	
	//Metodo de tipo Post (Creacion)
	@PostMapping("/pago")
	public ResponseEntity<Pago> CrearPago(@RequestBody Pago pago){
		try {
			Pago _pago = pagoRepository
					.save(new Pago(pago.getId(),pago.getForma()));
			return new ResponseEntity<>(_pago, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Metodo para mostrar todas las formas de pago
		@GetMapping("/pago")
		public ResponseEntity<List<Pago>> mostrarTodo(){

			List<Pago> pago = new ArrayList<Pago>();
			pagoRepository.findAll().forEach(pago::add);
			
			if(pago.isEmpty()) {
				 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(pago, HttpStatus.OK);
			}

		}
		
		// Mostrar por Id
		@GetMapping("/pago/{id}")
		public ResponseEntity<Pago> mostrarPorId(@PathVariable("id") long id){
			Optional<Pago> pago = pagoRepository.findById(id);
			if(pago.isPresent()) {
				return new ResponseEntity<>(pago.get(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		// Metodo Para Actualizar
		@PutMapping("/pago/{id}")
		public ResponseEntity<Pago> editarPago(@PathVariable("id") long id, @RequestBody Pago pago){
			
			Optional<Pago> pagoLista = pagoRepository.findById(id);
			
			if(pagoLista.isPresent()) {
				Pago _pago = pagoLista.get();
				_pago.setForma(pago.getForma());
				return new ResponseEntity<>(pagoRepository.save(_pago),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

		@DeleteMapping("/pago/{id}")
		public ResponseEntity<?> eliminarPago(@PathVariable("id") long id){
			
			try {
				pagoRepository.deleteById(id); // Ya se elimino
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}catch(Exception e) {
				 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
}
