package com.customerPOJO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Purchase {
	
	
	 @RequestMapping(value = "/users/{uuid}/discount", method=RequestMethod.GET, produces = MediaType.ALL_VALUE)
	 
	 public @ResponseBody DiscountResponse retriveDiscount(@PathVariable Integer uuid){
		 
		 BigDecimal amount=new BigDecimal(10);
		 BigDecimal amoun1t=new BigDecimal(5);
		 Discount discount=new  Discount("10-percent-off", "PERCENT", "Reduce the purchase price by 10%",amount, "");
		 Discount discount1=new  Discount("5-dollars-off", "AMOUNT", "Reduce the purchase price by $5",amoun1t, "sku-1234567890");
		 
		 List<Discount> discountList=new ArrayList();
		 discountList.add(discount);
		 discountList.add(discount1);
		 
		 DiscountResponse discountResponse=new DiscountResponse(discountList);
		 return discountResponse;
		 
		 
		 }
	 
	 
	/*//@RequestMapping(value= "/users/{uuid}/discount", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON) 
	//@ResponseBody DiscountResponse DiscountResponse

	void retriveDiscount(){
		
	}
	
	void getCustomer(){
		
	}*/
	
}
