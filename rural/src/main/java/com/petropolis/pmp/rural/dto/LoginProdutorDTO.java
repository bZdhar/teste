package com.petropolis.pmp.rural.dto;

public class LoginProdutorDTO {
	
	private String cpf;
	private String senha;
	
	public String getCpf() {
		return cpf;
	}
	public String getSenha() {
		return senha;
	}
	@Override
	public String toString() {
		return "LoginProdutorDTO [cpf=" + cpf + ", senha=" + senha + "]";
	}
	
	
}
