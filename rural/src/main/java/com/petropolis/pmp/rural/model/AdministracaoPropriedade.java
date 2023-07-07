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
@Table(name = "administracao_propriedade")
public class AdministracaoPropriedade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nota_fiscal")
	private Boolean notaFiscal;
	@Column(name = "declan")
	private Boolean declan;
	@Column(name = "deseja_credito_custo")
	private Boolean desejaCreditoCurso;
	@Column(name = "qual_custo")
	private String qualCurso;
	@Column(name = "utilizou_credito_rural")
	private Boolean utilizouCreditoRural;
	@Column(name = "qual_credito")
	private String qualCredito;
	@Column(name = "inscrito_inss")
	private Boolean inscritoInss;
	@OneToOne
	@JoinColumn(name = "id_dados_propriedades", referencedColumnName = "id")
	private DadosPropriedades dadosPropriedades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(Boolean notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Boolean getDeclan() {
		return declan;
	}

	public void setDeclan(Boolean declan) {
		this.declan = declan;
	}

	public Boolean getDesejaCreditoCurso() {
		return desejaCreditoCurso;
	}

	public void setDesejaCreditoCurso(Boolean desejaCreditoCurso) {
		this.desejaCreditoCurso = desejaCreditoCurso;
	}

	public String getQualCurso() {
		return qualCurso;
	}

	public void setQualCurso(String qualCurso) {
		this.qualCurso = qualCurso;
	}

	public Boolean getUtilizouCreditoRural() {
		return utilizouCreditoRural;
	}

	public void setUtilizouCreditoRural(Boolean utilizouCreditoRural) {
		this.utilizouCreditoRural = utilizouCreditoRural;
	}

	public String getQualCredito() {
		return qualCredito;
	}

	public void setQualCredito(String qualCredito) {
		this.qualCredito = qualCredito;
	}

	public Boolean getInscritoInss() {
		return inscritoInss;
	}

	public void setInscritoInss(Boolean inscritoInss) {
		this.inscritoInss = inscritoInss;
	}

	public DadosPropriedades getDadosPropriedades() {
		return dadosPropriedades;
	}

	public void setDadosPropriedades(DadosPropriedades dadosPropriedades) {
		this.dadosPropriedades = dadosPropriedades;
	}

}
