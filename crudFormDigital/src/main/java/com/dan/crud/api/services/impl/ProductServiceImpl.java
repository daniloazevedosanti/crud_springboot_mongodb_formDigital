package com.dan.crud.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.crud.api.models.Product;
import com.dan.crud.api.repositories.ProductRepository;
import com.dan.crud.api.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository produto;
	
	@Override
	public List<Product> listAll() {
		return this.produto.findAll();
	}

	@Override
	public Optional<Product> listById(String id) {
		return this.produto.findById(id);
	}

	@Override
	public Product register(Product obj) {
		return this.produto.save(obj);
	}

	@Override
	public void remove(String id) {
		this.produto.deleteById(id);
	}

	@Override
	public Product simularContratacao(String idProduto, String idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
