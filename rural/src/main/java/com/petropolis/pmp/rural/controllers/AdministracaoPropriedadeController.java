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

import com.petropolis.pmp.rural.model.AdministracaoPropriedade;
import com.petropolis.pmp.rural.services.AdministracaoPropriedadeService;

@RestController
@RequestMapping("administracaoPropriedade")
public class AdministracaoPropriedadeController {
    
    @Autowired
    AdministracaoPropriedadeService administracaoPropriedadeService;

    @GetMapping
    public ResponseEntity<List<AdministracaoPropriedade>> getAllAdiministracaoPropriedade() {
        return new ResponseEntity<>(administracaoPropriedadeService.getAllAdiministracaoPropriedade(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministracaoPropriedade> getAdministracaoById(@PathVariable Integer id) {
        AdministracaoPropriedade adiministracaoPropriedadeResponse = administracaoPropriedadeService.getAdiministracaoPropriedadeById(id);
        if (null == adiministracaoPropriedadeResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(adiministracaoPropriedadeResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdministracaoPropriedade> saveAdiministracaoPropriedade(@RequestBody AdministracaoPropriedade adiministracaoPropriedade) {
        return new ResponseEntity<>(administracaoPropriedadeService.saveAdiministracaoPropriedade(adiministracaoPropriedade), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AdministracaoPropriedade> updateAdiministracaoPropriedade(@RequestBody AdministracaoPropriedade adiministracaoPropriedade, @PathVariable Integer id) {
        AdministracaoPropriedade verificar = administracaoPropriedadeService.getAdiministracaoPropriedadeById(id);
        if (verificar == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        else 
            return new ResponseEntity<>(administracaoPropriedadeService.updateAdiministracaoPropriedade(adiministracaoPropriedade, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delAdiministracaoPropriedade(@PathVariable Integer id) {
        if (administracaoPropriedadeService.getAdiministracaoPropriedadeById(id) != null) {
            Boolean resp = administracaoPropriedadeService.deleteAdiministracaoPropriedade(id);
            if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
        }
        else 
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
