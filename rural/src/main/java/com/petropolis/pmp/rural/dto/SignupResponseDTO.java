package com.petropolis.pmp.rural.dto;
import java.util.List;

public class SignupResponseDTO {
  private String accessToken;
  private String type = "Bearer";
  private Long id;
  private String cpf;
  private List<String> roles;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public SignupResponseDTO(String accessToken, Long id, String cpf,  List<String> roles) {
    this.accessToken = accessToken;

    this.id = id;
    this.cpf = cpf;
    this.roles = roles;
  }
}
