package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.EstudanteModel;

public record CertificadoRecordDto(LocalDate dataEmissao, 
		Integer codigo, 
		EstudanteModel estudante) {

}
