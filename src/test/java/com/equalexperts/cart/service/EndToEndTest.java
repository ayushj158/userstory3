package com.equalexperts.cart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.equalexperts.cart.domain.OrderVO;

public class EndToEndTest {

	@Nested
	@DisplayName("Given An empty Shopping Cart And a product, Dove Soap with a unit price of 39.99")
	class AddItemTest {
		AddToCartService cart;

		@BeforeEach
		public void setup() {
			cart = new AddToCartService(1234);
		}

		@Test
		@DisplayName("When_user adds 2 Dove Soaps to shopping cart"
				+"And then adds another Axe Deo with a unit price of 99.99"
				+"And a sales tax rate of 12.5%"
				+ "_Then_Shopping cart should contain 2 Items"
				+"And the total sales tax amount for the shopping cart should equal 35.00"
				+ " And shopping cart’s total price should be 314.96")
		public void test_addItem() {
			final String productUPC = "Dove Soaps";
			final Double unitPrice = 39.99;
			final int  quantity= 2;
			cart.addItem(productUPC, unitPrice, quantity);
			cart.addItem("Axe Deo", 99.99,2);
			cart.getOrder().setTaxRate(12.5);
			OrderVO result = cart.calculateOrder(cart.getOrder());
			
			assertEquals(2, cart.getOrder().getOrderItems().size());
			assertEquals(2, cart.getOrder().getOrderItems().get(productUPC).getQuantity());
			assertEquals(2, cart.getOrder().getOrderItems().get("Axe Deo").getQuantity());
			assertEquals(unitPrice, cart.getOrder().getOrderItems().get(productUPC).getUnitPrice(),0.001);
			assertEquals(new BigDecimal(279.96).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPriceForItems());
			assertEquals(new BigDecimal(35.00).setScale(2, RoundingMode.HALF_DOWN),result.getTotalTax());
			assertEquals(new BigDecimal(314.96).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPrice());
			
		}
	}
}
