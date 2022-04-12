package com.torresdev.apirestcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torresdev.apirestcurso.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{
	// Creacion de Nuestro Repository
}
