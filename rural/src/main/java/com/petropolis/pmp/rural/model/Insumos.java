package com.petropolis.pmp.rural.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "insumos")
public class Insumos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(max = 100)
	@NotBlank(message = "campo obrigatorio")
	@Column(name = "produto")
	private String produto;
	@Size(max = 100)
	@Column(name = "quantidade_mensal")
	private String quantidadeMensal;
	@Size(max = 100)
	@Column(name = "local_compra")
	private String localCompra;
	@Column(name = "preco_insumo")
	private Double precoInsumo;
	@OneToOne
	@JoinColumn(name = "id_produtores", referencedColumnName = "id")
	private Produtores produtores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getQuantidadeMensal() {
		return quantidadeMensal;
	}

	public void setQuantidadeMensal(String quantidadeMensal) {
		this.quantidadeMensal = quantidadeMensal;
	}

	public String getLocalCompra() {
		return localCompra;
	}

	public void setLocalCompra(String localCompra) {
		this.localCompra = localCompra;
	}

	public Double getPrecoInsumo() {
		return precoInsumo;
	}

	public void setPrecoInsumo(Double precoInsumo) {
		this.precoInsumo = precoInsumo;
	}

	public Produtores getProdutores() {
		return produtores;
	}

	public void setProdutores(Produtores produtores) {
		this.produtores = produtores;
	}

}
