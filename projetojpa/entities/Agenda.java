package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "agenda")

public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "Ddd")
	private String Ddd;
	
	@Column(name = "telefone")
	private String telefone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long Id, Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDdd() {
		return Ddd;
	}
	public void setDdd(String Ddd) {
		this.Ddd = Ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}