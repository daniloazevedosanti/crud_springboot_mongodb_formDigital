package com.dan.crud.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.crud.api.models.Client;
import com.dan.crud.api.models.Product;
import com.dan.crud.api.repositories.ClientRepository;
import com.dan.crud.api.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository cliente;

	@Override
	public List<Client> listAll() {
		return this.cliente.findAll();
	}

	@Override
	public Optional<Client> listById(String id) {
		return this.cliente.findById(id);
	}

	@Override
	public Client register(Client obj) {
		return this.cliente.save(obj);
	}

	@Override
	public Client updateRegister(Client obj) {
		return this.cliente.save(obj);
	}

	@Override
	public void remove(String id) {
		this.cliente.deleteById(id);
	}

	@Override
	public Client Contratacao(Product produto, Client cliente) {
		if (cliente.getRenda() >= produto.getLimiteRenda()) {
			cliente.setProduto(produto.getId());
			var clienteAtualizado = this.cliente.save(cliente);
			return clienteAtualizado;
		}
		
		return null;
	}

}
