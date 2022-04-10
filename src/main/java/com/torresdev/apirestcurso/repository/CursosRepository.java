package com.torresdev.apirestcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torresdev.apirestcurso.entity.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Long>{

	// Creacion de Nuestro Repository
}
