package com.equalexperts.cart.domain;

public class ItemVO {

	private String upc;
	private Double unitPrice;
	private int quantity;
	public ItemVO(String upc, Double unitPrice,int quantity) {
		this.upc = upc;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Double getUnitPrice() {
		return unitPrice;
	}

	public String getUpc() {
		return upc;
	}
}
