package com.ecommerce.productservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecommerce.productservice.model.Product;

@Service
public interface ProductService {

	public Product createProduct(Product product);

	public List<Product> listAllProducts();

	public Product getProductById(int productId);

	public Product getProductByName(String productName);

	public Product updateProduct(int productId, Product product);

	public Map<String, Boolean> deleteProductById(int productId);

	public List<Product> getProductByCategory(String category);

	public List<Product> getProductByType(String productType);

}
