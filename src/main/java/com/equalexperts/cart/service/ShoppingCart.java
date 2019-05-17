package com.equalexperts.cart.service;

import com.equalexperts.cart.domain.OrderVO;

public interface ShoppingCart extends ModifyCart{
	public OrderVO initializeCart(int userId);
	
	public OrderVO calculateOrder();
}
