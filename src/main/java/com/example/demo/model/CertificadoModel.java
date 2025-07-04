package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CERTIFICADO")
public class CertificadoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private LocalDate dataEmissao;
	
	@Column(nullable = false, unique = true)
	private Integer codigo;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
		@OneToOne
		@JoinColumn(name = "estudante_id")
	private EstudanteModel estudante;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public EstudanteModel getEstudante() {
		return estudante;
	}

	public void setEstudante(EstudanteModel estudante) {
		this.estudante = estudante;
	}
	
	
	

}
