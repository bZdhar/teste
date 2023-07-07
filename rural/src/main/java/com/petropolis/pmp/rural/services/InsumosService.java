package com.petropolis.pmp.rural.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.Insumos;
import com.petropolis.pmp.rural.repositories.InsumosRepository;

@Service
public class InsumosService {
    
    @Autowired
    InsumosRepository insumosRepository;

    public List<Insumos> getAllInsumos() {
		return insumosRepository.findAll();
	}
	
	public Insumos getInsumosById(Integer id) {
		return insumosRepository.findById(id).orElse(null);
	}
	
	public Insumos saveInsumos(Insumos insumos) {
		return insumosRepository.save(insumos);
	}
	
	public Insumos updateInsumos(Insumos insumos, Integer id) {
		return insumosRepository.save(insumos);
	}
	
	public boolean deleteInsumos(Integer id) {
		insumosRepository.deleteById(id);
		Insumos insumosDeletado = insumosRepository.findById(id).orElse(null);
		if (null == insumosDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
