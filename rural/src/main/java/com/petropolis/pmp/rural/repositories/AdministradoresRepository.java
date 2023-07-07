package com.petropolis.pmp.rural.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.petropolis.pmp.rural.model.Administradores;
// import com.petropolis.pmp.rural.model.Produtores;

public interface AdministradoresRepository extends JpaRepository<Administradores, Integer>{
    
	//Escreva todos os dados, sem o *
		@Query(value = "Select * From administradores Where login=:login and senha=:senha", nativeQuery = true)
		public Administradores buscarAdministrador(String login, String senha);
}