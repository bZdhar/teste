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

import com.petropolis.pmp.rural.model.Insumos;
import com.petropolis.pmp.rural.services.InsumosService;

@RestController
@RequestMapping("/insumos")
public class InsumosController {
    
    @Autowired
    InsumosService insumosService;

    @GetMapping
	public ResponseEntity<List<Insumos>> getAllInsumos() {
		return new ResponseEntity<>(insumosService.getAllInsumos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Insumos> getInsumosById(@PathVariable Integer id) {
		Insumos insumosResponse = insumosService.getInsumosById(id);
		if (null == insumosResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(insumosResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Insumos> saveDadosPropriedades(@RequestBody Insumos insumos) {
		return new ResponseEntity<>(insumosService.saveInsumos(insumos), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Insumos> updateInsumos(@RequestBody Insumos insumos, @PathVariable Integer id) {
		Insumos verificar = insumosService.getInsumosById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(insumosService.updateInsumos(insumos, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delInsumos(@PathVariable Integer id) {
		if (insumosService.getInsumosById(id) != null) {
			Boolean resp = insumosService.deleteInsumos(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}
