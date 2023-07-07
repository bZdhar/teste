package com.petropolis.pmp.rural.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.Pecuaria;
import com.petropolis.pmp.rural.repositories.PecuariaRepository;

@Service
public class PecuariaService {
    
    @Autowired
    PecuariaRepository pecuariaRepository;

    public List<Pecuaria> getAllPecuaria() {
		return pecuariaRepository.findAll();
	}

    public Pecuaria getPecuariaById(Integer id) {
        return pecuariaRepository.findById(id).orElse(null);
    }

    public Pecuaria savePecuaria(Pecuaria pecuaria) {
        return pecuariaRepository.save(pecuaria);
    }

    public Pecuaria updatePecuaria(Pecuaria pecuaria, Integer id) {
        return pecuariaRepository.save(pecuaria);
    }

    public boolean deletePecuaria(Integer id) {
        pecuariaRepository.deleteById(id);
        Pecuaria pecuariaDeleteada = pecuariaRepository.findById(id).orElse(null);
        if (null == pecuariaDeleteada) {
            return true;
        } else {
            return false;
        }
    }
}
