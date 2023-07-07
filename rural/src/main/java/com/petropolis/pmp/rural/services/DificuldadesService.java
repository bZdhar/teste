package com.petropolis.pmp.rural.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.Dificuldades;
import com.petropolis.pmp.rural.repositories.DificuldadesRepository;

@Service
public class DificuldadesService {
    
    @Autowired
    DificuldadesRepository dificuldadesRepository;

    public List<Dificuldades> getAllDificuldades() {
		return dificuldadesRepository.findAll();
	}
	
	public Dificuldades getDificuldadesById(Integer id) {
		return dificuldadesRepository.findById(id).orElse(null);
	}
	
	public Dificuldades saveDificuldades(Dificuldades dificuldades) {
		return dificuldadesRepository.save(dificuldades);
	}
	
	public Dificuldades updateDificuldades(Dificuldades dificuldades, Integer id) {
		return dificuldadesRepository.save(dificuldades);
	}
	
	public boolean deleteDificuldades(Integer id) {
		dificuldadesRepository.deleteById(id);
		Dificuldades dificuldadesDeletado = dificuldadesRepository.findById(id).orElse(null);
		if (null == dificuldadesDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
