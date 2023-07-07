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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "producao_vegetais")
public class ProducaoVegetais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 2, max = 50)
	@NotBlank(message = "campo obrigatorio")
	@Column(name = "produto")
	private String produto;
	@Size(min = 2, max = 100)
	@NotBlank(message = "campo obrigatorio")
	@Column(name = "colheita")
	private String colheita;
	@Size(min = 2, max = 55)
	@NotBlank(message = "campo obrigatorio")
	@Column(name = "producao_kg")
	private String producaoKg;
	@NotEmpty
	@Column(name = "preco_produto")
	private Double precoProduto;
	@OneToOne
	@JoinColumn(name = "id_dadospropiedades", referencedColumnName = "id")
	private DadosPropriedades dadosPropiedades;

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

	public String getColheita() {
		return colheita;
	}

	public void setColheita(String colheita) {
		this.colheita = colheita;
	}

	public String getProducaoKg() {
		return producaoKg;
	}

	public void setProducaoKg(String producaoKg) {
		this.producaoKg = producaoKg;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public DadosPropriedades getDadosPropiedades() {
		return dadosPropiedades;
	}

	public void setDadosPropiedades(DadosPropriedades dadosPropiedades) {
		this.dadosPropiedades = dadosPropiedades;
	}

}
