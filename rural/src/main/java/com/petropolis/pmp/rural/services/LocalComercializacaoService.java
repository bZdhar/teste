package com.petropolis.pmp.rural.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.LocalComercializacao;
import com.petropolis.pmp.rural.repositories.LocalComercializacaoRepository;

@Service
public class LocalComercializacaoService {
	
	@Autowired 
	LocalComercializacaoRepository localComercializacaoRepository;
	
	public List<LocalComercializacao> getAllLocalComercializacao() {
		return localComercializacaoRepository.findAll();
	}
	
	public LocalComercializacao getLocalComercializacaoById(Integer id) {
		return localComercializacaoRepository.findById(id).orElse(null);
	}
	
	public LocalComercializacao saveLocalComercializacao(LocalComercializacao localComercializacao) {
		return localComercializacaoRepository.save(localComercializacao);
	}
	
	public LocalComercializacao updateLocalComercializacao(LocalComercializacao localComercializacao, Integer id) {
		return localComercializacaoRepository.save(localComercializacao);
	}
	
	public boolean deleteLocalComercializacao(Integer id) {
		localComercializacaoRepository.deleteById(id);
		LocalComercializacao localComercializacaoDeletado = localComercializacaoRepository.findById(id).orElse(null);
		if (null == localComercializacaoDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
