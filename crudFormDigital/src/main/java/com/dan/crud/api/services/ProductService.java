package com.dan.crud.api.services;

import java.util.List;
import java.util.Optional;

import com.dan.crud.api.models.Product;
import com.dan.crud.api.models.Client;

public interface ProductService {

	List<Product> listAll();
	
	Optional<Product> listById(String id);
	
	Product register(Product obj);
	
	void remove(String id);
	
	List<Product> simularContratacao(Client cliente);
}
