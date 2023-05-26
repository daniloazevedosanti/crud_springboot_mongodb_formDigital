package com.dan.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dan.crud.api.models.Client;


public interface ClientRepository extends MongoRepository<Client, String>{

}
