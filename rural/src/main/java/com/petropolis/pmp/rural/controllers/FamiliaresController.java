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

import com.petropolis.pmp.rural.model.Familiares;
import com.petropolis.pmp.rural.services.FamiliaresService;

@RestController 
@RequestMapping("/familiares")
public class FamiliaresController {
	
	@Autowired
	FamiliaresService familiaresService;
	
	@GetMapping
	public ResponseEntity<List<Familiares>> getAllFamiliaress(){
		return new ResponseEntity<>(familiaresService.getAllFamiliares(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Familiares> getFamiliaresById(@PathVariable Integer id){
		Familiares familiaresResponse = familiaresService.getFamiliaresById(id);
		if (null == familiaresResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(familiaresResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Familiares> saveFamiliares(@RequestBody Familiares familiares) {
		return new ResponseEntity<>(familiaresService.saveFamiliares(familiares), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Familiares> updateFamiliares(@RequestBody Familiares familiares,@PathVariable Integer id) {
		Familiares verificar = familiaresService.getFamiliaresById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(familiaresService.updateFamiliares(familiares, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delFamiliares(@PathVariable Integer id) {
		if (familiaresService.getFamiliaresById(id) != null) {
			Boolean resp = familiaresService.deleteFamiliares(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}