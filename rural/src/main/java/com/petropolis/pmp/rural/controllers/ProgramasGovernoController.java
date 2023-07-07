package com.petropolis.pmp.rural.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petropolis.pmp.rural.model.ProgramasGoverno;
import com.petropolis.pmp.rural.services.ProgramasGovernoService;

@RestController
@RequestMapping("/programas")
public class ProgramasGovernoController {

    @Autowired
    ProgramasGovernoService programasGovernoService;
    
    @GetMapping
	public ResponseEntity<List<ProgramasGoverno>> getAllProgramasGoverno() {
		return new ResponseEntity<>(programasGovernoService.getAllProgramasGoverno(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProgramasGoverno> getProgramasGovernoById(@PathVariable Integer id) {
		ProgramasGoverno programasGovernoResponse = programasGovernoService.getProgramasGovernoById(id);
		if (null == programasGovernoResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(programasGovernoResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProgramasGoverno> saveProgramasGoverno(@RequestBody ProgramasGoverno programasGoverno) {
		return new ResponseEntity<>(programasGovernoService.saveProgramasGoverno(programasGoverno), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProgramasGoverno> updateProgramasGoverno(@RequestBody ProgramasGoverno programasGoverno, @PathVariable Integer id) {
		ProgramasGoverno verificar = programasGovernoService.getProgramasGovernoById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(programasGovernoService.updateProgramasGoverno(programasGoverno, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delProgramasGoverno(@PathVariable Integer id) {
		if (programasGovernoService.getProgramasGovernoById(id) != null) {
			Boolean resp = programasGovernoService.deleteProgramasGoverno(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}
