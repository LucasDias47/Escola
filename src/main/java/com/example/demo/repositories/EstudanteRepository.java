package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EstudanteModel;

public interface EstudanteRepository extends JpaRepository<EstudanteModel, UUID>{

}
