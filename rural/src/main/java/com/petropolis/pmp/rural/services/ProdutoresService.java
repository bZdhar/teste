package com.petropolis.pmp.rural.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.petropolis.pmp.rural.dto.LoginRequestDTO;
import com.petropolis.pmp.rural.dto.SignupResponseDTO;
import com.petropolis.pmp.rural.enums.RoleEnum;
import com.petropolis.pmp.rural.model.Produtores;
import com.petropolis.pmp.rural.model.Role;
import com.petropolis.pmp.rural.repositories.ProdutoresRepository;
import com.petropolis.pmp.rural.repositories.RoleRepository;
import com.petropolis.pmp.rural.utils.JwtUtils;

import jakarta.transaction.Transactional;

@Service
public class ProdutoresService {

	@Autowired
    private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	ProdutoresRepository produtoresRepository;

	@Autowired
    private PasswordEncoder encoder;
	
	public List<Produtores> getAllProdutores() {
		return produtoresRepository.findAll();
	}
	
	public Produtores getProdutoById(Integer id) {
		return produtoresRepository.findById(id).orElse(null);
	}
	
	//Terá que codificar a senha?? Perguntar
	public Produtores saveProdutores(Produtores produtores) {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleEnum.USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        produtores.setRoles(roles);
				produtores.setSenha(encoder.encode(produtores.getSenha()));

				// List<RoleEnum> rolesList = roles.stream().map(Role::getName).collect(Collectors.toList());
		return produtoresRepository.save(produtores);
	}
		@Transactional
    public String logoutUser() {
        // UserDetailsImp userDetails = (UserDetailsImp) SecurityContextHolder.getContext()
        //         .getAuthentication()
        //         .getPrincipal();
        // Long userId = userDetails.getId();
        return "Log out successful!";
    }
		@Transactional
    public SignupResponseDTO authenticateUser(LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getCpf(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return new SignupResponseDTO(jwt, userDetails.getId(), userDetails.getCpf(), roles);
    }

	
	public Produtores updateProdutores(Produtores produtores, Integer id) {
		return produtoresRepository.save(produtores);
	}
	
	public boolean deleteProdutores(Integer id) {
		produtoresRepository.deleteById(id);
		Produtores produtoresDeletado = produtoresRepository.findById(id).orElse(null);
		if (null == produtoresDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
