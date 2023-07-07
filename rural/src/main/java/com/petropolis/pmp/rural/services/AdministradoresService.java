package com.petropolis.pmp.rural.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.dto.LoginAdministradorDTO;
// import com.petropolis.pmp.rural.dto.LoginProdutorDTO;
import com.petropolis.pmp.rural.model.Administradores;
// import com.petropolis.pmp.rural.model.Produtores;
import com.petropolis.pmp.rural.repositories.AdministradoresRepository;

@Service
public class AdministradoresService {
    
    @Autowired
    AdministradoresRepository administradoresRepository;

    public List<Administradores> getAllAdministradores() {
		return administradoresRepository.findAll();
	}
	
	public Administradores getAdministradoresById(Integer id) {
		return administradoresRepository.findById(id).orElse(null);
	}
	
	public Administradores saveAdministradores(Administradores administradores){
		administradores.setRole("ROLE_ADM");
		return administradoresRepository.save(administradores);
	}
	
	public Administradores loginAdministradores(LoginAdministradorDTO loginAdministrador) {
		//Login usando o repository
		System.out.println(loginAdministrador.getLogin() + " " + loginAdministrador.getSenha());
		return administradoresRepository.buscarAdministrador(loginAdministrador.getLogin(), loginAdministrador.getSenha());
	}
	
	public Administradores updateAdministradores(Administradores administradores, Integer id) {
		return administradoresRepository.save(administradores);
	}
	
	public boolean deleteAdministradores(Integer id) {
		administradoresRepository.deleteById(id);
		Administradores administradoresDeletado = administradoresRepository.findById(id).orElse(null);
		if (null == administradoresDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
