package com.petropolis.pmp.rural.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "programas_governo")
public class ProgramasGoverno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@Column(name = "conhece")
	private Boolean conhece;
	@NotEmpty
	@Column(name = "solo_correto")
	private Boolean soloCorreto;
	@NotEmpty
	@Column(name = "agricultura_correta")
	private Boolean agriculturaCorreta;
	@NotEmpty
	@Column(name = "composto_organico")
	private Boolean compostoOrganico;
	@NotEmpty
	@Column(name = "venda_direta")
	private Boolean vendaDireta;
	@OneToOne
	@JoinColumn(name = "id_produtores", referencedColumnName = "id")
	private Produtores produtores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getConhece() {
		return conhece;
	}

	public void setConhece(Boolean conhece) {
		this.conhece = conhece;
	}

	public Boolean getSoloCorreto() {
		return soloCorreto;
	}

	public void setSoloCorreto(Boolean soloCorreto) {
		this.soloCorreto = soloCorreto;
	}

	public Boolean getAgriculturaCorreta() {
		return agriculturaCorreta;
	}

	public void setAgriculturaCorreta(Boolean agriculturaCorreta) {
		this.agriculturaCorreta = agriculturaCorreta;
	}

	public Boolean getCompostoOrganico() {
		return compostoOrganico;
	}

	public void setCompostoOrganico(Boolean compostoOrganico) {
		this.compostoOrganico = compostoOrganico;
	}

	public Boolean getVendaDireta() {
		return vendaDireta;
	}

	public void setVendaDireta(Boolean vendaDireta) {
		this.vendaDireta = vendaDireta;
	}

	public Produtores getProdutores() {
		return produtores;
	}

	public void setProdutores(Produtores produtores) {
		this.produtores = produtores;
	}

}
