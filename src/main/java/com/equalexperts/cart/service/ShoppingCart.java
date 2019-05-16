package com.equalexperts.cart.service;

import com.equalexperts.cart.domain.OrderVO;

public interface ShoppingCart {

	public void addItem(final String upc,final Double price,final int quantity);
	
	public OrderVO initializeCart(int userId) ;
}
