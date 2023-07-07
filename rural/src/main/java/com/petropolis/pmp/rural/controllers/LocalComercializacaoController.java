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

import com.petropolis.pmp.rural.services.LocalComercializacaoService;
import com.petropolis.pmp.rural.model.LocalComercializacao;

@RestController
@RequestMapping("/localComercializacao")
public class LocalComercializacaoController {
    
    @Autowired
    LocalComercializacaoService localComercializacaoService;

    @GetMapping
    public ResponseEntity<List<LocalComercializacao>> getAllLocalComercializacao() {
        return new ResponseEntity<>(localComercializacaoService.getAllLocalComercializacao(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalComercializacao> getLocalComercializacaoById(@PathVariable Integer id) {
        LocalComercializacao localComercializacaoResponse = localComercializacaoService.getLocalComercializacaoById(id);
        if (null == localComercializacaoResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(localComercializacaoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocalComercializacao> saveLocalComercializacao(@RequestBody LocalComercializacao localComercializacao) {
        return new ResponseEntity<>(localComercializacaoService.saveLocalComercializacao(localComercializacao), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LocalComercializacao> updateLocalComercializacao(@RequestBody LocalComercializacao localComercializacao, @PathVariable Integer id) {
        LocalComercializacao verificar = localComercializacaoService.getLocalComercializacaoById(id);
        if (verificar == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        else 
            return new ResponseEntity<>(localComercializacaoService.updateLocalComercializacao(localComercializacao, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delLocalComercializacao(@PathVariable Integer id) {
        if (localComercializacaoService.getLocalComercializacaoById(id) != null) {
            Boolean resp = localComercializacaoService.deleteLocalComercializacao(id);
            if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
        }
        else 
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

