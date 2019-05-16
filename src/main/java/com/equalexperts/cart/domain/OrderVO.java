package com.equalexperts.cart.domain;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

public class OrderVO {
	private long orderId;
	private int userId;
	private double taxRate;
	private BigDecimal totalTax;
	private BigDecimal totalPriceForItems;
	private BigDecimal totalPrice;
	private Map<String,ItemVO> orderItems;

	public OrderVO(int userId) {
		this.userId = userId;
		this.orderId = new Random().nextLong();
	}

	public long getOrderId() {
		return orderId;
	}
	
	public int getUserId() {
		return userId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<String, ItemVO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Map<String, ItemVO> orderItems) {
		this.orderItems = orderItems;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public BigDecimal getTotalPriceForItems() {
		return totalPriceForItems;
	}

	public void setTotalPriceForItems(BigDecimal totalPriceForItems) {
		this.totalPriceForItems = totalPriceForItems;
	}

}
