package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ESTUDANTE")
public class EstudanteModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany(mappedBy = "estudantes", fetch = FetchType.LAZY)
	private Set<CursoModel> cursos = new HashSet<>();
	
	@OneToOne(mappedBy = "estudante", cascade = CascadeType.ALL)
	private CertificadoModel certificado;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<CursoModel> getCursos() {
		return cursos;
	}

	public void setCursos(Set<CursoModel> cursos) {
		this.cursos = cursos;
	}

	public CertificadoModel getCertificado() {
		return certificado;
	}

	public void setCertificado(CertificadoModel certificado) {
		this.certificado = certificado;
	}
	
	
	
	
	

}
