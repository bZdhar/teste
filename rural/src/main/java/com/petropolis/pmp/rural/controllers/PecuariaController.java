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

import com.petropolis.pmp.rural.services.PecuariaService;
import com.petropolis.pmp.rural.model.Pecuaria;

@RestController
@RequestMapping("/pecuaria")
public class PecuariaController {
    
    @Autowired
    PecuariaService pecuariaService;

    @GetMapping
    public ResponseEntity<List<Pecuaria>> getAllPecuaria() {
        return new ResponseEntity<>(pecuariaService.getAllPecuaria(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pecuaria> getPecuariaById(@PathVariable Integer id) {
        Pecuaria pecuariaResponse = pecuariaService.getPecuariaById(id);
        if (null == pecuariaResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(pecuariaResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pecuaria> savePecuaria(@RequestBody Pecuaria pecuaria) {
        return new ResponseEntity<>(pecuariaService.savePecuaria(pecuaria), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pecuaria> updatePecuaria(@RequestBody Pecuaria pecuaria, @PathVariable Integer id) {
        Pecuaria verificar = pecuariaService.getPecuariaById(id);
        if (verificar == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        else 
            return new ResponseEntity<>(pecuariaService.updatePecuaria(pecuaria, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delPecuaria(@PathVariable Integer id) {
        if (pecuariaService.getPecuariaById(id) != null) {
            Boolean resp = pecuariaService.deletePecuaria(id);
            if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
        }
        else 
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
