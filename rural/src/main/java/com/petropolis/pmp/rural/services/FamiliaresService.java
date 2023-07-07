package com.petropolis.pmp.rural.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.Familiares;
import com.petropolis.pmp.rural.repositories.FamiliaresRepository;

@Service
public class FamiliaresService {
	
	@Autowired 
	FamiliaresRepository familiaresRepository;
	
	public List<Familiares> getAllFamiliares() {
		return familiaresRepository.findAll();
	}
	
	public Familiares getFamiliaresById(Integer id) {
		return familiaresRepository.findById(id).orElse(null);
	}
	
	public Familiares saveFamiliares(Familiares familiares) {
		return familiaresRepository.save(familiares);
	}
	
	public Familiares updateFamiliares(Familiares familiares, Integer id) {
		return familiaresRepository.save(familiares);
	}
	
	public boolean deleteFamiliares(Integer id) {
		familiaresRepository.deleteById(id);
		Familiares familiaresDeletado = familiaresRepository.findById(id).orElse(null);
		if (null == familiaresDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
