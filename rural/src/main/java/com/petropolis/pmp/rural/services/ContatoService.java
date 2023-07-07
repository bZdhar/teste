package com.petropolis.pmp.rural.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.Contato;
import com.petropolis.pmp.rural.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired 
	ContatoRepository contatoRepository;
	
	public List<Contato> getAllContato() {
		return contatoRepository.findAll();
	}
	
	public Contato getContatoById(Integer id) {
		return contatoRepository.findById(id).orElse(null);
	}
	
	public Contato saveContato(Contato contato) {
		return contatoRepository.save(contato);
	}
	
	public Contato updateContato(Contato contato, Integer id) {
		return contatoRepository.save(contato);
	}
	
	public boolean deleteContato(Integer id) {
		contatoRepository.deleteById(id);
		Contato contatoDeletado = contatoRepository.findById(id).orElse(null);
		if (null == contatoDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
