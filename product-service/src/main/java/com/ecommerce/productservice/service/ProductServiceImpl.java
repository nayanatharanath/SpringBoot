package com.ecommerce.productservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.productservice.exception.CategoryNotFoundException;
import com.ecommerce.productservice.exception.ProductAlreadyExistsException;
import com.ecommerce.productservice.exception.ProductNotFoundException;
import com.ecommerce.productservice.exception.ProductTypeNotExistsException;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Override
	public Product createProduct(Product product) throws ProductAlreadyExistsException {
		if (productRepo.existsById(product.getProductId())) {
			throw new ProductAlreadyExistsException();
		}
		return productRepo.save(product);
	}

	@Override
	public List<Product> listAllProducts() {
		List<Product> allpro = productRepo.findAll();
		return allpro;
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFoundException {
		return productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException());
	}

	@Override
	public Product getProductByName(String productName) throws ProductNotFoundException {
		Product product;
		if (productRepo.findByProductName(productName).isEmpty()) {
			throw new ProductNotFoundException();
		} else {
			product = productRepo.findByProductName(productName).get();
		}
		return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) throws ProductNotFoundException {
		Product updatedProduct = productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException());

		updatedProduct.setCategory(product.getCategory());
		updatedProduct.setProductDescription(product.getProductDescription());
		updatedProduct.setProductImgURL(product.getProductImgURL());
		updatedProduct.setProductName(product.getProductName());
		updatedProduct.setProductId(product.getProductId());
		updatedProduct.setProductPrice(product.getProductPrice());
		updatedProduct.setProductRating(product.getProductRating());
		updatedProduct.setProductSpecification(product.getProductSpecification());
		updatedProduct.setProductReview(product.getProductReview());
		updatedProduct.setProductType(product.getProductType());

		final Product finalUpdatedProduct = productRepo.save(updatedProduct);

		return finalUpdatedProduct;
	}

	@Override
	public Map<String, Boolean> deleteProductById(int productId) throws ProductNotFoundException {
		Product product = productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException());
		productRepo.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

	@Override
	public List<Product> getProductByCategory(String category) throws CategoryNotFoundException {
		List<Product> product;
		if (productRepo.findByCategory(category).isEmpty()) {
			throw new CategoryNotFoundException();
		} else {
			product = productRepo.findByCategory(category);
		}
		return product;
	}

	@Override
	public List<Product> getProductByType(String productType) throws ProductTypeNotExistsException {
		List<Product> product;
		if (productRepo.findByProductType(productType).isEmpty()) {
			throw new ProductTypeNotExistsException();
		} else {
			product = productRepo.findByProductType(productType);
		}
		return product;
	}

}
