package com.example.demo.dto;

import java.util.List;

public record CursoRecordDto(String nome, 
		String descricao, 
		List<EstudanteRecordDto>estudantes) {

	
}
