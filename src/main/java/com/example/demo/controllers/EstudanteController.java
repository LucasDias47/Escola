package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EstudanteRecordDto;
import com.example.demo.model.EstudanteModel;
import com.example.demo.service.EstudanteService;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
	
	private final EstudanteService estudanteService;

	public EstudanteController(EstudanteService estudanteService) {
		
		this.estudanteService = estudanteService;
	}
	
	@PostMapping
	public ResponseEntity<EstudanteModel>saveEstudante(@RequestBody EstudanteRecordDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(estudanteService.saveEstudante(dto));
	}
	
	@GetMapping
    public ResponseEntity<List<EstudanteModel>> getAllEstudantes() {
        return ResponseEntity.ok(estudanteService.getAllEstudantes());
    }
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<String> deleteEstudante(@PathVariable UUID id) {
	        estudanteService.deleteEstudante(id);
	        return ResponseEntity.ok("Estudante deletado com sucesso.");
	    }
	
	
	
	

}
