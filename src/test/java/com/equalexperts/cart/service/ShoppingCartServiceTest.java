package com.equalexperts.cart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.equalexperts.cart.domain.ItemVO;
import com.equalexperts.cart.domain.OrderVO;

public class ShoppingCartServiceTest {

	@Nested
	@DisplayName("Given_Empty Shopping Cart")
	class CalculateOrderTest {
		OrderCalculateService calculateOrder;

		OrderVO mockOrder;

		@BeforeEach
		void setup() {
			calculateOrder = new OrderCalculateService();
			
		}
		
		@Test
		@DisplayName("When_Order contains 5 items each with price 39.99"
				+ "_Then_Shopping cart should have total price of 199.95")
		public void test_calculateOrder() {
			OrderVO mockOrder = OrderTestData.createMockOrder(1, 5, 39.99);
			OrderVO result = calculateOrder.calculateOrder(mockOrder);
			
			assertEquals(new BigDecimal(199.95).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPrice());
		}
		

		@Test
		@DisplayName("When_Order contains 4 items each with price 39.99"
				+ "_Then_Shopping cart should have total price of 159.95 with decimal rounded down")
		public void test_calculateOrder_rounddown() {
			OrderVO mockOrder = OrderTestData.createMockOrder(1, 4, 39.988);
			OrderVO result = calculateOrder.calculateOrder(mockOrder);
			
			assertEquals(new BigDecimal(159.95).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPrice());
		}
		
		
		@Test
		@DisplayName("When_Order contains 4 items each with price 39.989_"
				+ "Then_Shopping cart should have total price of 159.96 with decimal rounded up")
		public void test_calculateOrder_round_up() {
			OrderVO mockOrder = OrderTestData.createMockOrder(1, 4, 39.989);
			OrderVO result = calculateOrder.calculateOrder(mockOrder);
			
			assertEquals(new BigDecimal(159.96).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPrice());
		}
		
		@Test
		@DisplayName("When_Order Does not have any item_"
				+ "Then_Shopping cart should have total price 0")
		public void test_calculateOrder_EmptyCart() {
			OrderVO mockOrder = new OrderVO(1234);
			mockOrder.setOrderItems(new HashMap<String,ItemVO>());
			OrderVO result = calculateOrder.calculateOrder(mockOrder);
			
			assertEquals(new BigDecimal(0.00).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPrice());
		}
		
		@Test
		@DisplayName("When_Order Does not have any item_"
				+ "Then_Shopping cart should have total price 0")
		public void test_calculateOrder_WithTax() {
			OrderVO mockOrder = OrderTestData.createMockOrder(1, 5, 39.99);
			mockOrder.setTaxRate(12.5);
			OrderVO result = calculateOrder.calculateOrder(mockOrder);
			
			assertEquals(new BigDecimal(24.99).setScale(2, RoundingMode.HALF_DOWN),result.getTotalTax());
			assertEquals(new BigDecimal(199.95).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPriceForItems());
			assertEquals(new BigDecimal(224.94).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPrice());
		}
	}
}
