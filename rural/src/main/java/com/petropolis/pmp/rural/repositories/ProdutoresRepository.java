package com.petropolis.pmp.rural.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

import com.petropolis.pmp.rural.model.Produtores;

public interface ProdutoresRepository extends JpaRepository<Produtores, Integer> {

Optional<Produtores> findByCpf(String cpf);
	
	//Escreva todos os dados, sem o *
	@Query(value = "Select * From produtores Where cpf=:cpf and senha=:senha", nativeQuery = true)
	public Produtores buscarProdutor(String cpf, String senha);
	
	//HQL - não usa o nome da coluna da tabela, mas sim o nome da propriedade
	//@Query(value = "SELECT p.id, p.complemento, p.senha, p.nomeProdutor, p.endereco, p.role, p.comunidade, p.localidade, p.cpf FROM Produtores p WHERE p.cpf = :cpf AND p.senha = :senha")
	//public Produtores buscarProdutorHQL(@Param("cpf") String cpf, @Param("senha") String senha);
}
