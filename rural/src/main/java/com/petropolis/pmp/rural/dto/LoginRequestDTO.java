package com.petropolis.pmp.rural.dto;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {
  
  @NotBlank
  private String username;

  @NotBlank
  private String password;

  public String getCpf() {
    return username;
  }

  public void setCpf(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}