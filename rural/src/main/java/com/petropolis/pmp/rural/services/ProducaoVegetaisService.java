package com.petropolis.pmp.rural.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.ProducaoVegetais;
import com.petropolis.pmp.rural.repositories.ProducaoVegetaisRepository;

@Service
public class ProducaoVegetaisService {
    
    @Autowired
    ProducaoVegetaisRepository producaoVegetaisRepository;

    public List<ProducaoVegetais> getAllProducaoVegetais() {
        return producaoVegetaisRepository.findAll();
    }

    public ProducaoVegetais getProducaoVegetaisById(Integer id) {
        return producaoVegetaisRepository.findById(id).orElse(null);
    }

    public ProducaoVegetais saveProducaoVegetais(ProducaoVegetais producaoVegetais) {
        return producaoVegetaisRepository.save(producaoVegetais);
    }

    public ProducaoVegetais updateProducaoVegetais(ProducaoVegetais producaoVegetais, Integer id) {
        return producaoVegetaisRepository.save(producaoVegetais);
    }

    public boolean deleteProducaoVegetais(Integer id) {
        producaoVegetaisRepository.deleteById(id);
        ProducaoVegetais producaoVegetaisDeleteada = producaoVegetaisRepository.findById(id).orElse(null);
        if (null == producaoVegetaisDeleteada) {
            return true;
        } else {
            return false;
        }
    }
}
