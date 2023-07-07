package com.petropolis.pmp.rural.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "local_comercializacao")
public class LocalComercializacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@Column(name = "varejo_local")
	private Boolean varejoLocal;
	@NotEmpty
	@Column(name = "atacado_local")
	private Boolean atacadoLocal;
	@NotEmpty
	@Column(name = "varejo_outras_cidades")
	private Boolean varejoOutrasCidades;
	@NotEmpty
	@Column(name = "atacado_outras_cidades")
	private Boolean atacadoOutrasCidades;
	@NotEmpty
	@Column(name = "progamas_municipai")
	private Boolean programasMunicipais;
	@NotEmpty
	@Column(name = "outras_receitas")
	private Boolean outrasReceitas;
	@Size(max = 200)
	@Column(name = "obs")
	private String obs;
	@ManyToOne
	@JoinColumn(name = "id_produtores", referencedColumnName = "id")
	private Produtores produtores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getVarejoLocal() {
		return varejoLocal;
	}

	public void setVarejoLocal(Boolean varejoLocal) {
		this.varejoLocal = varejoLocal;
	}

	public Boolean getAtacadoLocal() {
		return atacadoLocal;
	}

	public void setAtacadoLocal(Boolean atacadoLocal) {
		this.atacadoLocal = atacadoLocal;
	}

	public Boolean getVarejoOutrasCidades() {
		return varejoOutrasCidades;
	}

	public void setVarejoOutrasCidades(Boolean varejoOutrasCidades) {
		this.varejoOutrasCidades = varejoOutrasCidades;
	}

	public Boolean getAtacadoOutrasCidades() {
		return atacadoOutrasCidades;
	}

	public void setAtacadoOutrasCidades(Boolean atacadoOutrasCidades) {
		this.atacadoOutrasCidades = atacadoOutrasCidades;
	}

	public Boolean getProgramasMunicipais() {
		return programasMunicipais;
	}

	public void setProgramasMunicipais(Boolean programasMunicipais) {
		this.programasMunicipais = programasMunicipais;
	}

	public Boolean getOutrasReceitas() {
		return outrasReceitas;
	}

	public void setOutrasReceitas(Boolean outrasReceitas) {
		this.outrasReceitas = outrasReceitas;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Produtores getProdutores() {
		return produtores;
	}

	public void setProdutores(Produtores produtores) {
		this.produtores = produtores;
	}

}
