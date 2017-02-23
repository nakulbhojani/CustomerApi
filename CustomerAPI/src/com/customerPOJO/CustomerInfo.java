package com.customerPOJO;

import java.util.List;

public class CustomerInfo {
	
	String uuid;
	String name;
	String address;
	List<Discount> eligibleDiscounts;
	List<PurchasedProducts> products;
	
	public CustomerInfo()
	{
		
		
	}
	

	public CustomerInfo(String uuid, String name, String address, List<Discount> eligibleDiscounts,
			List<PurchasedProducts> products) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.address = address;
		this.eligibleDiscounts = eligibleDiscounts;
		this.products = products;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Discount> getEligibleDiscounts() {
		return eligibleDiscounts;
	}

	public void setEligibleDiscounts(List<Discount> eligibleDiscounts) {
		this.eligibleDiscounts = eligibleDiscounts;
	}

	public List<PurchasedProducts> getProducts() {
		return products;
	}

	public void setProducts(List<PurchasedProducts> products) {
		this.products = products;
	}
	
	

}
