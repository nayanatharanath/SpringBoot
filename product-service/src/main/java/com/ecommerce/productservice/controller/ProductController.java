package com.ecommerce.productservice.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.productservice.exception.ProductNotFoundException;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
// @CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@PostMapping("/add")
	public ResponseEntity<Product> addProducts(@RequestBody Product product) {
		Product addedUser = productService.createProduct(product);
		return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
	}

	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {
		return productService.listAllProducts();
	}

	@GetMapping("/findById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable int productId) {
		return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.FOUND);
	}

	@GetMapping("/findByType/{productType}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable String productType) {
		return new ResponseEntity<>(productService.getProductByType(productType), HttpStatus.FOUND);
	}

	@GetMapping("/findByName/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable String productName) {
		return new ResponseEntity<>(productService.getProductByName(productName), HttpStatus.FOUND);
	}

	@GetMapping("/findByCategory/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
		return new ResponseEntity<>(productService.getProductByCategory(category), HttpStatus.FOUND);
	}

	@PutMapping("/update/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productId, @Valid @RequestBody Product product)
			throws ProductNotFoundException {
		return ResponseEntity.ok(productService.updateProduct(productId, product));
	}

	@DeleteMapping("/delete/{productId}")
	public Map<String, Boolean> deleteProduct(@PathVariable int productId) throws ProductNotFoundException {
		return productService.deleteProductById(productId);
	}

}
