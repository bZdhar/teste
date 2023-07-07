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

import com.petropolis.pmp.rural.dto.LoginAdministradorDTO;
import com.petropolis.pmp.rural.model.Administradores;
import com.petropolis.pmp.rural.services.AdministradoresService;

@RestController
@RequestMapping("/admin")
public class AdministradoresController {
    
    @Autowired
    AdministradoresService administradoresService;

    @GetMapping
	public ResponseEntity<List<Administradores>> getAllAdministradores(){
		return new ResponseEntity<>(administradoresService.getAllAdministradores(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Administradores> getAdministradoresById(@PathVariable Integer id){
		Administradores administradoresResponse = administradoresService.getAdministradoresById(id);
		if (null == administradoresResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(administradoresResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Administradores> saveAdministradores(@RequestBody Administradores administradores) {
		return new ResponseEntity<>(administradoresService.saveAdministradores(administradores), HttpStatus.CREATED);
	}
	
	@PostMapping("/loginAdministrador")
	public ResponseEntity<Administradores> loginAdministrador(@RequestBody LoginAdministradorDTO loginAdministradorDTO){
		if (loginAdministradorDTO == null) 
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);		
		else {
			if (administradoresService.loginAdministradores(loginAdministradorDTO) == null) {
				return new ResponseEntity<>(administradoresService.loginAdministradores(loginAdministradorDTO), HttpStatus.NOT_FOUND);
			}
			else
				return new ResponseEntity<>(administradoresService.loginAdministradores(loginAdministradorDTO), HttpStatus.OK);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Administradores> updateAdministradores(@RequestBody Administradores administradores,@PathVariable Integer id) {
		Administradores verificar = administradoresService.getAdministradoresById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(administradoresService.updateAdministradores(administradores, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delAdministradores(@PathVariable Integer id) {
		if (administradoresService.getAdministradoresById(id) != null) {
			Boolean resp = administradoresService.deleteAdministradores(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}
