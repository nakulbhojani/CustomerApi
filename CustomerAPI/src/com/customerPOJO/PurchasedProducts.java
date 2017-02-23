package com.customerPOJO;

import java.math.BigDecimal;

public class PurchasedProducts {

	String productId;
	String description;
	BigDecimal originalPrice;
	BigDecimal finalPrice;
	Discount discountInformation;
	
	public PurchasedProducts(String productId, String description, java.math.BigDecimal originalPrice,
			java.math.BigDecimal finalPrice, Discount discountInformation) {
		super();
		this.productId = productId;
		this.description = description;
		this.originalPrice = originalPrice;
		this.finalPrice = finalPrice;
		this.discountInformation = discountInformation;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	
	
	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Discount getDiscountInformation() {
		return discountInformation;
	}

	public void setDiscountInformation(Discount discountInformation) {
		this.discountInformation = discountInformation;
	}
	
	
	
}
