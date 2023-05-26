package com.dan.crud.api.services;

import java.util.List;
import java.util.Optional;

import com.dan.crud.api.models.Product;

public interface ProductService {

	List<Product> listAll();
	
	Optional<Product> listById(String id);
	
	Product register(Product obj);
	
	//Product updateRegister(Product obj);
	
	void remove(String id);
	
	Product simularContratacao(String idProduto, String idCliente);
}
