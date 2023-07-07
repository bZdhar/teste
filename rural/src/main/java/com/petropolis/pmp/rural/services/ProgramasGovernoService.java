package com.petropolis.pmp.rural.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.model.ProgramasGoverno;
import com.petropolis.pmp.rural.repositories.ProgramasGovernoRepository;

@Service
public class ProgramasGovernoService {
    
    @Autowired
    ProgramasGovernoRepository programasGovernoRepository;

    public List<ProgramasGoverno> getAllProgramasGoverno() {
		return programasGovernoRepository.findAll();
	}
	
	public ProgramasGoverno getProgramasGovernoById(Integer id) {
		return programasGovernoRepository.findById(id).orElse(null);
	}
	
	public ProgramasGoverno saveProgramasGoverno(ProgramasGoverno programasGoverno) {
		return programasGovernoRepository.save(programasGoverno);
	}
	
	public ProgramasGoverno updateProgramasGoverno(ProgramasGoverno programasGoverno, Integer id) {
		return programasGovernoRepository.save(programasGoverno);
	}
	
	public boolean deleteProgramasGoverno(Integer id) {
		programasGovernoRepository.deleteById(id);
		ProgramasGoverno programasGovernoDeletado = programasGovernoRepository.findById(id).orElse(null);
		if (null == programasGovernoDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
