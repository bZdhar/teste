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
@Table(name = "familiares")
public class Familiares {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ate_sete")
	private Integer ateSete;
	@Column(name = "oito_a_quinze")
	private Integer oitoAQuinze;
	@Column(name = "desesseis_a_vinte_cinco")
	private Integer desesseisAVinteCinco;
	@Column(name = "vinte_seis_a_sessenta_cinco")
	private Integer vinteSeisASessentaCinco;
	@Column(name = "mais_sessento_cinco")
	private Integer maisSessentoCinco;
	@Column(name = "familiares_producao")
	private Integer familiaresProducao;
	@Column(name = "auxiliares")
	private Integer auxiliares;
	@OneToOne
	@JoinColumn(name = "id_produtores", referencedColumnName = "id")
	private Produtores produtores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAteSete() {
		return ateSete;
	}

	public void setAteSete(Integer ateSete) {
		this.ateSete = ateSete;
	}

	public Integer getOitoAQuinze() {
		return oitoAQuinze;
	}

	public void setOitoAQuinze(Integer oitoAQuinze) {
		this.oitoAQuinze = oitoAQuinze;
	}

	public Integer getDesesseisAVinteCinco() {
		return desesseisAVinteCinco;
	}

	public void setDesesseisAVinteCinco(Integer desesseisAVinteCinco) {
		this.desesseisAVinteCinco = desesseisAVinteCinco;
	}

	public Integer getVinteSeisASessentaCinco() {
		return vinteSeisASessentaCinco;
	}

	public void setVinteSeisASessentaCinco(Integer vinteSeisASessentaCinco) {
		this.vinteSeisASessentaCinco = vinteSeisASessentaCinco;
	}

	public Integer getMaisSessentoCinco() {
		return maisSessentoCinco;
	}

	public void setMaisSessentoCinco(Integer maisSessentoCinco) {
		this.maisSessentoCinco = maisSessentoCinco;
	}

	public Integer getFamiliaresProducao() {
		return familiaresProducao;
	}

	public void setFamiliaresProducao(Integer familiaresProducao) {
		this.familiaresProducao = familiaresProducao;
	}

	public Integer getAuxiliares() {
		return auxiliares;
	}

	public void setAuxiliares(Integer auxiliares) {
		this.auxiliares = auxiliares;
	}

	public Produtores getProdutores() {
		return produtores;
	}

	public void setProdutores(Produtores produtores) {
		this.produtores = produtores;
	}

}
