package com.petropolis.pmp.rural.model;

import com.petropolis.pmp.rural.enums.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    @Enumerated(EnumType.STRING)
    @NotBlank
    private RoleEnum name;


    public Long getId() {
      return id;
    }


    public void setId(Long id) {
      this.id = id;
    }


    public RoleEnum getName() {
      return name;
    }


    public void setName(RoleEnum name) {
      this.name = name;
    }


    
    
}
