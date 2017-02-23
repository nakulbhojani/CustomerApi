package com.customerPOJO;

import java.util.List;

public class DiscountResponse{

	List<Discount> discountList;

	public DiscountResponse() {
		super();
	}
	public DiscountResponse(List<Discount> discountList) {
		super();
		this.discountList = discountList;
	}
	public List<Discount> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<Discount> discountList) {
		this.discountList = discountList;
	}
	
	
	
	
}
