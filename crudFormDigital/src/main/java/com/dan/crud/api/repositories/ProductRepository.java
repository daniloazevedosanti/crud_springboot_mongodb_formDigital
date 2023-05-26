package com.dan.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dan.crud.api.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
