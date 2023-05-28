package com.dan.crud.api.services;

import java.util.List;
import java.util.Optional;

import com.dan.crud.api.models.Client;
import com.dan.crud.api.models.Product;

public interface ClientService {

	List<Client> listAll();

	Optional<Client> listById(String id);

	Client register(Client obj);

	Client updateRegister(Client obj);

	void remove(String id);

	Client Contratacao(Product produto, Client cliente);
}
