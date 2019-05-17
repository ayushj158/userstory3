package com.equalexperts.cart.service;

import java.util.HashMap;

import com.equalexperts.cart.domain.ItemVO;
import com.equalexperts.cart.domain.OrderVO;

public class ShoppingCartService extends OrderCalculateService implements ShoppingCart {

	private OrderVO order;

	AddToCartService addToCartService;

	public ShoppingCartService(int userId) {
		if (null == this.order) {
			this.order = initializeCart(userId);
		}
		addToCartService = new AddToCartService(this.order);
	}
	
	@Override
	public OrderVO initializeCart(int userId) {
		this.order = new OrderVO(userId);
		this.order.setOrderItems(new HashMap<String, ItemVO>());
		return this.order;
	}
	
	@Override
	public OrderVO calculateOrder() {
		return super.calculateOrder(this.order);
	}
	
	@Override
	public void add(final String upc, final Double price, final int quantity) {
		addToCartService.add(upc, price, quantity);
	}
	

	public OrderVO getOrder() {
		return order;
	}

}