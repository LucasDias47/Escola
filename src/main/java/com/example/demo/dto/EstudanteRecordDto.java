package com.example.demo.dto;

import java.util.List;

public record EstudanteRecordDto(String nome, 
		String email,
		List<CursoRecordDto>cursos,
		CertificadoRecordDto certificado
		) {

}
