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

import com.petropolis.pmp.rural.Exception.ApiError;
import com.petropolis.pmp.rural.Exception.ProdutoresException;
import com.petropolis.pmp.rural.dto.LoginRequestDTO;
import com.petropolis.pmp.rural.dto.SignupResponseDTO;
import com.petropolis.pmp.rural.model.Produtores;
import com.petropolis.pmp.rural.services.ProdutoresService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/produtores")
public class ProdutoresController {
	
	@Autowired
	ProdutoresService produtoresService;
	
	@GetMapping
	public ResponseEntity<List<Produtores>> getAllProdutoress() {
		return new ResponseEntity<>(produtoresService.getAllProdutores(), HttpStatus.OK);
	}
	  @PostMapping("/sign-out")
    @SecurityRequirement(name = "token")
    public ResponseEntity<String> logoutUser() {
        return ResponseEntity.ok(produtoresService.logoutUser());
    }
 		 @PostMapping("/sign-in")
    @Operation(summary = "Sign In Service", description = "Sign In Service", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully Singned In!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SignupResponseDTO.class))),
            @ApiResponse(responseCode = "400", ref = "BadRequest"),
            @ApiResponse(responseCode = "401", ref = "badcredentials"),
            @ApiResponse(responseCode = "422", ref = "unprocessableEntity"),
            @ApiResponse(responseCode = "500", ref = "internalServerError")
    })
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        try {
            SignupResponseDTO signupResponse = produtoresService.authenticateUser(loginRequest);
            return ResponseEntity.ok().header("Authorization", signupResponse.getAccessToken()).body(signupResponse);
        } catch (ProdutoresException e) {
            return ResponseEntity.unprocessableEntity().body(
                new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessable Entity", e.getLocalizedMessage()));
        }
    }

	@GetMapping("/{id}")
	public ResponseEntity<Produtores> getProdutoresById(@PathVariable Integer id) {
		Produtores produtoresResponse = produtoresService.getProdutoById(id);
		if (null == produtoresResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(produtoresResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Produtores> saveProdutores(@RequestBody Produtores produtores) {
		if (produtores == null) 
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);		
		else 
			return new ResponseEntity<>(produtoresService.saveProdutores(produtores), HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Produtores> updateProdutores(@RequestBody Produtores produtores,@PathVariable Integer id) {
		Produtores verificar = produtoresService.getProdutoById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(produtoresService.updateProdutores(produtores, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delProdutores(@PathVariable Integer id) {
		if (produtoresService.getProdutoById(id) != null) {
			Boolean resp = produtoresService.deleteProdutores(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}
