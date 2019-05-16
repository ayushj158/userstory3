package com.equalexperts.cart.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import com.equalexperts.cart.domain.ItemVO;
import com.equalexperts.cart.domain.OrderVO;

public class OrderTestData {

	public static Map<String, ItemVO> createMockOrderItems(final int noOfItems, final int perItemQuantity,
			final Double unitPrice) {
		Map<String, ItemVO> mockOrderItems = new HashMap<String, ItemVO>();
		for (int i = 0; i < noOfItems; i++) {
			mockOrderItems.put("Item" + i, new ItemVO("Item" + i, unitPrice, perItemQuantity));
		}
		return mockOrderItems;
	}
	
	public static OrderVO createMockOrder(final int noOfItems, final int perItemQuantity,
			final Double unitPrice) {
		OrderVO mockOrder = new OrderVO(3145);
		mockOrder.setOrderItems(createMockOrderItems(1, perItemQuantity,unitPrice));
		return mockOrder;
	}
	
	public static void main(String[] args) {
		System.out.println(BigDecimal.valueOf(0.979).setScale(2, RoundingMode.HALF_DOWN));
		System.out.println(BigDecimal.valueOf(.99).setScale(0, RoundingMode.HALF_UP));
	}
}
