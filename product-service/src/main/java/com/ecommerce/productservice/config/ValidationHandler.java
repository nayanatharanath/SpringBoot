package com.ecommerce.productservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ecommerce.productservice.exception.CategoryNotFoundException;
import com.ecommerce.productservice.exception.ProductAlreadyExistsException;
import com.ecommerce.productservice.exception.ProductNotFoundException;
import com.ecommerce.productservice.exception.ProductTypeNotExistsException;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	// validation handler for handling error message when validation fails
	// @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

	// handles exception if product not found
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundexception(ProductNotFoundException productNotFoundException) {
		return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
	}

	// handles exception if product already exists
	@ExceptionHandler(value = ProductAlreadyExistsException.class)
	public ResponseEntity<String> productAlreadyExistsException(
			ProductAlreadyExistsException productAlreadyExistsException) {
		return new ResponseEntity<>("Product already exists", HttpStatus.CONFLICT);
	}

	// handles exception if category not found
	@ExceptionHandler(value = CategoryNotFoundException.class)
	public ResponseEntity<String> categoryNotFoundException(CategoryNotFoundException categoryNotFoundException) {
		return new ResponseEntity<>("category not found", HttpStatus.NOT_FOUND);
	}

	// handles exception if product type not found
	@ExceptionHandler(value = ProductTypeNotExistsException.class)
	public ResponseEntity<String> productTypeNotExistsException(CategoryNotFoundException categoryNotFoundException) {
		return new ResponseEntity<>("product type does not exists", HttpStatus.NOT_FOUND);
	}
}
