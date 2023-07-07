package com.petropolis.pmp.rural.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.petropolis.pmp.rural.model.Produtores;



public class UserDetailsImp implements UserDetails {
  
  private static final long serialVersionUID = 1L;

  private Long id;

  private Boolean isActive;

  private String cpf;
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImp(Long id, String cpf, String password, Boolean isActive, 
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.cpf = cpf;
    this.password = password;
    this.isActive = isActive;
    this.authorities = authorities;
  }

  public static UserDetailsImp build(Produtores produtores) {
    List<? extends GrantedAuthority> authorities = produtores.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImp(
        produtores.getId(),
        produtores.getCpf(),
        produtores.getSenha(),
        produtores.getIsActive(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String getPassword() {
    return password;
  }

 @Override
  public boolean isEnabled() {
    return isActive;
  }


  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImp user = (UserDetailsImp) o;
    return Objects.equals(id, user.id);
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return cpf;
  }

  
}