package com.dan.crud.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.dan.crud.api.models.Product;

import com.dan.crud.api.repositories.ProductRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ProductRepository prodRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		prodRepository.deleteAll();
		
		Product cartaoOuro = new Product (null, "Cartão Ouro", 10000.00, "ouro");
		Product cartaoPrata = new Product (null, "Cartão Prata", 5000.00, "prata");
		Product cartaoBronze = new Product (null, "Cartão Bronze", 1500.00, "bronze");
		
		prodRepository.saveAll(Arrays.asList(cartaoOuro, cartaoPrata, cartaoBronze));
		
		/*
		  	private String id;
			private String nomeProduto;
			private Double limiteRenda;
			private String tipo; // 'tipo' pode ser um "enum" com a designação do tipo
		*/
	}

}
