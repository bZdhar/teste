package com.petropolis.pmp.rural.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "celular", unique = true)
	private String celular;
	@Column(name = "telefone", unique = true)
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "id_produtores", referencedColumnName = "id")
	private Produtores produtores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Produtores getProdutores() {
		return produtores;
	}

	public void setProdutores(Produtores produtores) {
		this.produtores = produtores;
	}
}
