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

import com.petropolis.pmp.rural.model.Dificuldades;
import com.petropolis.pmp.rural.services.DificuldadesService;

@RestController
@RequestMapping("/dificuldades")
public class DificuldadesController {
    
    @Autowired
    DificuldadesService dificuldadesService;

    @GetMapping
	public ResponseEntity<List<Dificuldades>> getAllDificuldades() {
		return new ResponseEntity<>(dificuldadesService.getAllDificuldades(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dificuldades> getDificuldadesById(@PathVariable Integer id) {
		Dificuldades dificuldadesResponse = dificuldadesService.getDificuldadesById(id);
		if (null == dificuldadesResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(dificuldadesResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Dificuldades> saveDadosPropriedades(@RequestBody Dificuldades dificuldades) {
		return new ResponseEntity<>(dificuldadesService.saveDificuldades(dificuldades), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Dificuldades> updateDificuldades(@RequestBody Dificuldades dificuldades, @PathVariable Integer id) {
		Dificuldades verificar = dificuldadesService.getDificuldadesById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(dificuldadesService.updateDificuldades(dificuldades, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delInsumos(@PathVariable Integer id) {
		if (dificuldadesService.getDificuldadesById(id) != null) {
			Boolean resp = dificuldadesService.deleteDificuldades(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}
