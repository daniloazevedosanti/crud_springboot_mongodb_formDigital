package com.dan.crud.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String id;
	private String nomeProduto;
	private Double limiteRenda;
	private String tipo;
	
	public Product() {
		
	}
	
	public Product(String id, String nomeProduto, Double limiteRenda, String tipo) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.limiteRenda = limiteRenda;
		this.tipo = tipo;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Double getLimiteRenda() {
		return limiteRenda;
	}
	public void setLimiteRenda(Double limiteRenda) {
		this.limiteRenda = limiteRenda;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
