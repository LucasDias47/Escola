package com.example.demo.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CursoRecordDto;
import com.example.demo.dto.EstudanteRecordDto;
import com.example.demo.model.CertificadoModel;
import com.example.demo.model.CursoModel;
import com.example.demo.model.EstudanteModel;
import com.example.demo.repositories.CertificadoRepository;
import com.example.demo.repositories.CursoRepository;
import com.example.demo.repositories.EstudanteRepository;

import jakarta.transaction.Transactional;

@Service
public class EstudanteService {
	
	private final EstudanteRepository estudanteRepository;
	private final CursoRepository cursoRepository;
	private final CertificadoRepository certificadoRepository;
	
	public EstudanteService(EstudanteRepository estudanteRepository, CursoRepository cursoRepository,
			CertificadoRepository certificadoRepository) {
		
		this.estudanteRepository = estudanteRepository;
		this.cursoRepository = cursoRepository;
		this.certificadoRepository = certificadoRepository;
	}
	
	@Transactional
	public EstudanteModel saveEstudante(EstudanteRecordDto dto) {
		EstudanteModel estudante = new EstudanteModel();
		estudante.setNome(dto.nome());
		estudante.setEmail(dto.email());
		
		Set<CursoModel> cursos = dto.cursos().stream().map(cursoDto ->{
			CursoModel curso = new CursoModel();
			curso.setNome(cursoDto.nome());
			curso.setDescricao(cursoDto.descricao());
			return curso;
		}).collect(Collectors.toSet());
		estudante.setCursos(cursos);
		
		CertificadoModel certificado = new CertificadoModel();
		certificado.setDataEmissao(dto.certificado().dataEmissao());
		certificado.setCodigo(dto.certificado().codigo());
		certificado.setEstudante(estudante);
		estudante.setCertificado(certificado);
		
		
		
		return estudanteRepository.save(estudante);
		
		
	}
	
	public List<EstudanteModel> getAllEstudantes() {
	    return estudanteRepository.findAll();
	}

	public void deleteEstudante(UUID id) {
	    estudanteRepository.deleteById(id);
	}
	
	

}
