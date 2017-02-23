package com.customerPOJO;

import java.math.BigDecimal;

public class Discount {

	String discountId;
	String type;
	String description;
	BigDecimal amount;
	String productID =null;
	public String getDiscountId() {
		return discountId;
	}
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public Discount(String discountId, String type, String description, BigDecimal amount, String productID) {
		super();
		this.discountId = discountId;
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.productID = productID;
	}
	
	public Discount(String discountId, String type, String description, BigDecimal amount) {
		super();
		this.discountId = discountId;
		this.type = type;
		this.description = description;
		this.amount = amount;

	}
	 
	 
	
}
