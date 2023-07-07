package com.petropolis.pmp.rural.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.Produtores;
import com.petropolis.pmp.rural.repositories.ProdutoresRepository;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsImpService implements UserDetailsService {
  
  @Autowired
  ProdutoresRepository produtoresRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String cpf) {
    Optional<Produtores> user = produtoresRepository.findByCpf(cpf);
    

    return UserDetailsImp.build(user.get());
  }
}
