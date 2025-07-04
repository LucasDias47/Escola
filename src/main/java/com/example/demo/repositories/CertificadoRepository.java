package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CertificadoModel;

public interface CertificadoRepository extends JpaRepository<CertificadoModel, UUID>{

}
