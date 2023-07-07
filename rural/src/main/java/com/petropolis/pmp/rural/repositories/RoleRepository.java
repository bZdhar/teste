package com.petropolis.pmp.rural.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petropolis.pmp.rural.enums.RoleEnum;
import com.petropolis.pmp.rural.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(RoleEnum roleUser);
  
}