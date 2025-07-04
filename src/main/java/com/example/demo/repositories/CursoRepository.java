package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CursoModel;

public interface CursoRepository extends JpaRepository<CursoModel, 
UUID> {

	CursoModel findCursoModelByNome(String nome);
}
