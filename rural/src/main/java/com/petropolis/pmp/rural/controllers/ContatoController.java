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

import com.petropolis.pmp.rural.model.Contato;
import com.petropolis.pmp.rural.services.ContatoService;

@RestController 
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	ContatoService contatoService;
	
	@GetMapping
	public ResponseEntity<List<Contato>> getAllContatos(){
		return new ResponseEntity<>(contatoService.getAllContato(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contato> getContatoById(@PathVariable Integer id){
		Contato contatoResponse = contatoService.getContatoById(id);
		if (null == contatoResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(contatoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Contato> saveContato(@RequestBody Contato contato) {
		return new ResponseEntity<>(contatoService.saveContato(contato), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contato> updateContato(@RequestBody Contato contato,@PathVariable Integer id) {
		Contato verificar = contatoService.getContatoById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(contatoService.updateContato(contato, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delContato(@PathVariable Integer id) {
		if (contatoService.getContatoById(id) != null) {
			Boolean resp = contatoService.deleteContato(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}
