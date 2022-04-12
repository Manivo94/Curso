package com.torresdev.apirestcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torresdev.apirestcurso.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long>{
	// Creacion de Nuestro Repository
}
