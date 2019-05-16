package com.equalexperts.cart.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

import com.equalexperts.cart.domain.ItemVO;
import com.equalexperts.cart.domain.OrderVO;

public class OrderCalculateService implements OrderCalculate {

	public OrderVO calculateOrder(OrderVO order) {
		order.setTotalPriceForItems(calculateOrderItems(order));
		order.setTotalTax(calculateTax(order));
		order.setTotalPrice(
				order.getTotalPriceForItems().add(order.getTotalTax()).setScale(2, RoundingMode.HALF_DOWN));
		return order;
	}

	private BigDecimal calculateTax(OrderVO order) {
		return (order.getTotalPriceForItems().multiply(BigDecimal.valueOf(order.getTaxRate()/100))).setScale(2,
				RoundingMode.HALF_DOWN);
	}

	private BigDecimal calculateOrderItems(OrderVO order) {
		final Double orderLinesTotal = order.getOrderItems().entrySet().stream().map(i -> i)
				.collect(Collectors.summingDouble(i -> calculateOrderItem(i.getValue())));
		return BigDecimal.valueOf(orderLinesTotal).setScale(2, RoundingMode.HALF_DOWN);
	}

	private Double calculateOrderItem(ItemVO orderItem) {
		return orderItem.getUnitPrice() * orderItem.getQuantity();
	}
}
