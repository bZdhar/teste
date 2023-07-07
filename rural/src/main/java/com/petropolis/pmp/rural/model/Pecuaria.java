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
@Table(name = "pecuaria")
public class Pecuaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "criacao")
	private String criacao;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "raca")
	private String raca;
	@Column(name = "numero")
	private String numero;
	@Column(name = "vacinacao")
	private String vacinacao;
	@Column(name = "tipo_vacina")
	private Boolean tipoVacina;
	@Column(name = "exames")
	private String exames;
	@OneToOne
	@JoinColumn(name = "id_dadospropiedades", referencedColumnName = "id")
	private DadosPropriedades dadosPropiedades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCriacao() {
		return criacao;
	}

	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(String vacinacao) {
		this.vacinacao = vacinacao;
	}

	public Boolean getTipoVacina() {
		return tipoVacina;
	}

	public void setTipoVacina(Boolean tipoVacina) {
		this.tipoVacina = tipoVacina;
	}

	public String getExames() {
		return exames;
	}

	public void setExames(String exames) {
		this.exames = exames;
	}

	public DadosPropriedades getDadosPropiedades() {
		return dadosPropiedades;
	}

	public void setDadosPropiedades(DadosPropriedades dadosPropiedades) {
		this.dadosPropiedades = dadosPropiedades;
	}

}
