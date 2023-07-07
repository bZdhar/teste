package com.petropolis.pmp.rural.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.DadosPropriedades;
import com.petropolis.pmp.rural.repositories.DadosPropriedadesRepository;

@Service
public class DadosPropriedadesService {
	
	@Autowired 
	DadosPropriedadesRepository dadosPropriedadesRepository;
	
	public List<DadosPropriedades> getAllDadosPropriedades() {
		return dadosPropriedadesRepository.findAll();
	}
	
	public DadosPropriedades getDadosPropriedadesById(Integer id) {
		return dadosPropriedadesRepository.findById(id).orElse(null);
	}
	
	public DadosPropriedades saveDadosPropriedades(DadosPropriedades dadosPropriedades) {
		return dadosPropriedadesRepository.save(dadosPropriedades);
	}
	
	public DadosPropriedades updateDadosPropriedades(DadosPropriedades dadosPropriedades, Integer id) {
		return dadosPropriedadesRepository.save(dadosPropriedades);
	}
	
	public boolean deleteDadosPropriedades(Integer id) {
		dadosPropriedadesRepository.deleteById(id);
		DadosPropriedades dadosPropriedadesDeletado = dadosPropriedadesRepository.findById(id).orElse(null);
		if (null == dadosPropriedadesDeletado) {
			return true;
		} else {
			return false;
		}
	}
}