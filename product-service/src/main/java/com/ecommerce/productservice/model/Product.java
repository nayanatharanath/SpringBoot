package com.ecommerce.productservice.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* to define the product service as a mongoDB document */
@Document(collection = "Product")
public class Product {
	@Id
	private int productId;

	@NotEmpty(message = "Product Type is empty")
	private String productType;

	@NotEmpty(message = "Product Name is empty")
	private String productName;

	private String category;

	private String productRating;

	private String productReview;

	private String productImgURL;

	@NotNull
	private double productPrice;

	private String productDescription;

	private String productSpecification;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, @NotEmpty(message = "Product Type is empty") String productType,
			@NotEmpty(message = "Product Name is empty") String productName, String category, String productRating,
			String productReview, String productImgURL, @NotNull double productPrice, String productDescription,
			String productSpecification) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.productRating = productRating;
		this.productReview = productReview;
		this.productImgURL = productImgURL;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productSpecification = productSpecification;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductRating() {
		return productRating;
	}

	public void setProductRating(String productRating) {
		this.productRating = productRating;
	}

	public String getProductReview() {
		return productReview;
	}

	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}

	public String getProductImgURL() {
		return productImgURL;
	}

	public void setProductImgURL(String productImgURL) {
		this.productImgURL = productImgURL;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

}
