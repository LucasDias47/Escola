package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CURSO")
public class CursoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String descricao;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany(fetch = FetchType.LAZY)
	/*
	@JoinTable(
			name = "tb_curso_estudante",
			joinColumns = @JoinColumn(name = "curso_id"),
			inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	*/
	private Set<EstudanteModel> estudantes = new HashSet<>();

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<EstudanteModel> getEstudantes() {
		return estudantes;
	}

	public void setEstudantes(Set<EstudanteModel> estudantes) {
		this.estudantes = estudantes;
	}
	
	
	
	
	
}
