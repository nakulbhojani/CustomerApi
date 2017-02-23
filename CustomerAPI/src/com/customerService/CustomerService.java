package com.customerService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.customerPOJO.CustomerInfo;
import com.customerPOJO.Discount;

import com.customerPOJO.ErrorResource;
import com.customerPOJO.PurchasedProducts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CustomerService {

	String jsonString = null;

	@RequestMapping(value = "/rest/v1/users/{uuid}/discounts", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String retrieveDiscount(@PathVariable String uuid,
			@RequestParam(value = "productId", required = false) String productId) {
		
		if (productId == null) {
			if (!uuid.equalsIgnoreCase("bad-user")) {
				String jsonString = null;

				List<Discount> discountList = getDiscounts();
				ObjectMapper mapper = new ObjectMapper();
				
				try {
					jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(discountList);
				} catch (JsonProcessingException e) {

					e.printStackTrace();
				}

				return jsonString;
			} else {
				ErrorResource errorResource = new ErrorResource();
				errorResource.setCode("ER0002");
				errorResource.setMessage("Bad request - user not found in the system");
				ObjectMapper mapper = new ObjectMapper();
				try {
					jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorResource);
				} catch (JsonProcessingException e) {

					e.printStackTrace();
				}
				return jsonString;
			}
		} else {
			int i = 0;
			List<Discount> discountList = getDiscounts();
			for (Discount d : discountList) {
				
				if (productId.equalsIgnoreCase(d.getProductID())) {
					i = 1;
					ObjectMapper mapper = new ObjectMapper();
					try {
						jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(d);
					} catch (JsonProcessingException e) {

						e.printStackTrace();
					}
					return jsonString;
				}

			}
			if (i == 0) {

				ErrorResource errorResource = new ErrorResource();
				errorResource.setCode("ER0002");
				errorResource.setMessage("no discount found for the productid: " + productId);
				ObjectMapper mapper = new ObjectMapper();
				try {
					jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorResource);
				} catch (JsonProcessingException e) {

					e.printStackTrace();
				}
				return jsonString;

			}
		}
		return jsonString;
	}

	@RequestMapping(value = "/rest/v1/customers/{uuid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getCustomerDetails(@PathVariable String uuid) {

		if (!uuid.equalsIgnoreCase("bad-user")) {

			String name = "Test User";
			String address = "1 Main St";
			List<Discount> eligibleDiscounts = getDiscounts();
			List<PurchasedProducts> products = new ArrayList<PurchasedProducts>();

			BigDecimal amt = new BigDecimal(10);
			Discount discount = new Discount("10-percent-off", "PERCENT", "Reduce the purchase price by 10%", amt,
					"sku-1234567890");

			BigDecimal amount = new BigDecimal(100);
			BigDecimal amount1 = new BigDecimal(50);
			PurchasedProducts pp1 = new PurchasedProducts("sku-1234567890",
					"12 month subscription to 'Horse and Hound'", amount, amount1, discount);
			products.add(pp1);

			CustomerInfo customerInfo = new CustomerInfo(uuid, name, address, eligibleDiscounts, products);

			ObjectMapper mapper = new ObjectMapper();
			try {
				jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerInfo);
			} catch (JsonProcessingException e) {

				e.printStackTrace();
			}
			return jsonString;
		} else {

			ErrorResource errorResource = new ErrorResource();
			errorResource.setCode("ER0002");
			errorResource.setMessage("Bad request - user not found in the system");
			ObjectMapper mapper = new ObjectMapper();
			try {
				jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorResource);
			} catch (JsonProcessingException e) {

				e.printStackTrace();
			}
			return jsonString;

		}

	}

	public List<Discount> getDiscounts() {
		BigDecimal amount = new BigDecimal(10);
		BigDecimal amount1 = new BigDecimal(5);
		Discount discount = new Discount("10-percent-off", "PERCENT", "Reduce the purchase price by 10%", amount, "");
		Discount discount1 = new Discount("5-dollars-off", "AMOUNT", "Reduce the purchase price by $5", amount1,
				"sku-1234567890");

		List<Discount> discountList = new ArrayList();
		discountList.add(discount);
		discountList.add(discount1);
		return discountList;
	}

}
