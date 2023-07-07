package com.petropolis.pmp.rural.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dados_propriedade")
public class DadosPropriedades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(max = 200)
	@NotBlank(message = "campo obrigatorio")
	@Column(name = "nome_propriedade")
	private String nomePropriedade;
	@NotNull
	@Column(name = "area_total")
	private Integer areaTotal;
	@NotEmpty
	@Column(name = "proprietario")
	private boolean proprietario;
	@NotEmpty
	@Column(name = "em_seu_nome")
	private boolean emSeuNome;
	@NotEmpty
	@Column(name = "arrendado")
	private boolean arrendado;
	@NotEmpty
	@Column(name = "com_contrto")
	private boolean comContrato;
	@ManyToOne
	@JoinColumn(name = "id_produtores", referencedColumnName = "id")
	private Produtores produtores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePropriedade() {
		return nomePropriedade;
	}

	public void setNomePropriedade(String nomePropriedade) {
		this.nomePropriedade = nomePropriedade;
	}

	public Integer getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(Integer areaTotal) {
		this.areaTotal = areaTotal;
	}

	public boolean isProprietario() {
		return proprietario;
	}

	public void setProprietario(boolean proprietario) {
		this.proprietario = proprietario;
	}

	public boolean isEmSeuNome() {
		return emSeuNome;
	}

	public void setEmSeuNome(boolean emSeuNome) {
		this.emSeuNome = emSeuNome;
	}

	public boolean isArrendado() {
		return arrendado;
	}

	public void setArrendado(boolean arrendado) {
		this.arrendado = arrendado;
	}

	public boolean isComContrato() {
		return comContrato;
	}

	public void setComContrato(boolean comContrato) {
		this.comContrato = comContrato;
	}

	public Produtores getProdutores() {
		return produtores;
	}

	public void setProdutores(Produtores produtores) {
		this.produtores = produtores;
	}

}
