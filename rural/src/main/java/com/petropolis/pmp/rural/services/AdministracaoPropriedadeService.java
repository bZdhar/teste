package com.petropolis.pmp.rural.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.AdministracaoPropriedade;
import com.petropolis.pmp.rural.repositories.AdministracaoPropriedadeRepository;

@Service
public class AdministracaoPropriedadeService {
    
    @Autowired
    AdministracaoPropriedadeRepository administracaoPropriedadeRepository;

    public List<AdministracaoPropriedade> getAllAdiministracaoPropriedade() {
		return administracaoPropriedadeRepository.findAll();
	}

    public AdministracaoPropriedade getAdiministracaoPropriedadeById(Integer id) {
        return administracaoPropriedadeRepository.findById(id).orElse(null);
    }

    public AdministracaoPropriedade saveAdiministracaoPropriedade(AdministracaoPropriedade adiministracaoPropriedade) {
        return administracaoPropriedadeRepository.save(adiministracaoPropriedade);
    }

    public AdministracaoPropriedade updateAdiministracaoPropriedade(AdministracaoPropriedade adiministracaoPropriedade, Integer id) {
        return administracaoPropriedadeRepository.save(adiministracaoPropriedade);
    }

    public boolean deleteAdiministracaoPropriedade(Integer id) {
        administracaoPropriedadeRepository.deleteById(id);
        AdministracaoPropriedade administracaoPropriedadeDeleteada = administracaoPropriedadeRepository.findById(id).orElse(null);
        if (null == administracaoPropriedadeDeleteada) {
            return true;
        } else {
            return false;
        }
    }
}
