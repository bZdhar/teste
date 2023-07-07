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

import com.petropolis.pmp.rural.model.ProducaoVegetais;
import com.petropolis.pmp.rural.services.ProducaoVegetaisService;

@RestController
@RequestMapping("producaoVegetal")
public class ProducaoVegetaisController {
    
    @Autowired
    ProducaoVegetaisService producaoVegetaisService;

    @GetMapping
    public ResponseEntity<List<ProducaoVegetais>> getAllProducaoVegetais() {
        return new ResponseEntity<>(producaoVegetaisService.getAllProducaoVegetais(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducaoVegetais> getProducaoVegetaisById(@PathVariable Integer id) {
        ProducaoVegetais producaoVegetaisResponse = producaoVegetaisService.getProducaoVegetaisById(id);
        if (null == producaoVegetaisResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(producaoVegetaisResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProducaoVegetais> saveProducaoVegetais(@RequestBody ProducaoVegetais producaoVegetais) {
        return new ResponseEntity<>(producaoVegetaisService.saveProducaoVegetais(producaoVegetais), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProducaoVegetais> updateProducaoVegetais(@RequestBody ProducaoVegetais producaoVegetais, @PathVariable Integer id) {
        ProducaoVegetais verificar = producaoVegetaisService.getProducaoVegetaisById(id);
        if (verificar == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        else 
            return new ResponseEntity<>(producaoVegetaisService.updateProducaoVegetais(producaoVegetais, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delProducaoVegetais(@PathVariable Integer id) {
        if (producaoVegetaisService.getProducaoVegetaisById(id) != null) {
            Boolean resp = producaoVegetaisService.deleteProducaoVegetais(id);
            if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
        }
        else 
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
