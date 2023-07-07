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

import com.petropolis.pmp.rural.model.DadosPropriedades;
import com.petropolis.pmp.rural.services.DadosPropriedadesService;

@RestController 
@RequestMapping("/dadosPropriedades")
public class DadosPropriedadesController {
	
	@Autowired
	DadosPropriedadesService dadosPropriedadesService;
	
	@GetMapping
	public ResponseEntity<List<DadosPropriedades>> getAllDadosPropriedades() {
		return new ResponseEntity<>(dadosPropriedadesService.getAllDadosPropriedades(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DadosPropriedades> getDadosPropriedadesById(@PathVariable Integer id) {
		DadosPropriedades dadosPropriedadesResponse = dadosPropriedadesService.getDadosPropriedadesById(id);
		if (null == dadosPropriedadesResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(dadosPropriedadesResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<DadosPropriedades> saveDadosPropriedades(@RequestBody DadosPropriedades dadosPropriedades) {
		return new ResponseEntity<>(dadosPropriedadesService.saveDadosPropriedades(dadosPropriedades), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DadosPropriedades> updateDadosPropriedades(@RequestBody DadosPropriedades dadosPropriedades,@PathVariable Integer id) {
		DadosPropriedades verificar = dadosPropriedadesService.getDadosPropriedadesById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(dadosPropriedadesService.updateDadosPropriedades(dadosPropriedades, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delDadosPropriedades(@PathVariable Integer id) {
		if (dadosPropriedadesService.getDadosPropriedadesById(id) != null) {
			Boolean resp = dadosPropriedadesService.deleteDadosPropriedades(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}