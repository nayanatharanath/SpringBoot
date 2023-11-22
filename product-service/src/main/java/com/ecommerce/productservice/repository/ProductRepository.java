package com.ecommerce.productservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.productservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
	
	public Optional<Product> findByProductName(String productName);
	
	public List<Product> findByCategory(String category);
	
	public List<Product> findByProductType(String productType);

}
