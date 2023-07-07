package com.petropolis.pmp.rural.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dificuldades")
public class Dificuldades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "producao")
	private String producao;
	@Column(name = "infra_estrutura")
	private String infraEstrutura;
	@Column(name = "comercializacao")
	private String comercializacao;

	@OneToOne
	@JoinColumn(name = "id_produtores", referencedColumnName = "id")
	private Produtores produtores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProducao() {
		return producao;
	}

	public void setProducao(String producao) {
		this.producao = producao;
	}

	public String getInfraEstrutura() {
		return infraEstrutura;
	}

	public void setInfraEstrutura(String infraEstrutura) {
		this.infraEstrutura = infraEstrutura;
	}

	public String getComercializacao() {
		return comercializacao;
	}

	public void setComercializacao(String comercializacao) {
		this.comercializacao = comercializacao;
	}

	public Produtores getProdutores() {
		return produtores;
	}

	public void setProdutores(Produtores produtores) {
		this.produtores = produtores;
	}

}
