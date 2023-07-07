package com.petropolis.pmp.rural.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produtores")
public class Produtores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CPF(message = "CPF invalido")
	@NotBlank(message = "preencha com seu cpf")
	@Size(max = 11)
	@Column(name = "cpf", unique = true)
	private String cpf;
	@Size( max = 100)
	@NotBlank(message = "preencha com seu nome")
	@Column(name = "nome_produtor")
	private String nomeProdutor;
	@Size(min = 8, max = 250)
	@NotBlank(message = "preencha a senha")
	@Column(name = "senha")
	private String senha;
	@Size(min = 5, max = 150)
	@NotBlank(message = "preencha com o endereço da propriedade")
	@Column(name = "endereco")
	private String endereco;
	@Size(min = 5, max = 100)
	@Column(name = "complemento")
	private String complemento;
	@Size(min = 5, max = 100)
	@Column(name = "comunidade")
	private String comunidade;
	@Size(min = 5, max = 100)
	@Column(name = "localidade")
	private String localidade;
	@Column(name = "is_active")
  @NotNull
  private Boolean isActive;
	@ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
  private Set<Role> roles = new HashSet<>();


		public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Produtores() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeProdutor() {
		return nomeProdutor;
	}

	public void setNomeProdutor(String nomeProdutor) {
		this.nomeProdutor = nomeProdutor;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComunidade() {
		return comunidade;
	}

	public void setComunidade(String comunidade) {
		this.comunidade = comunidade;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	@Override
	public String toString() {
		return "Produtores [id=" + id + ", cpf=" + cpf + ", nome_produtor=" + nomeProdutor + ", senha=" + senha
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", comunidade=" + comunidade
				+ ", localidade=" + localidade + "]";
	}

}
