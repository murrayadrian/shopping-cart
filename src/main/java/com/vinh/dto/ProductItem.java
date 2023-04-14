package com.vinh.dto;

import com.vinh.entity.Product;

public class ProductItem {
	
	private Product product;
	private int quantity;
	private double totalPrice;
	
	public ProductItem(Product product) {
		this.product = product;
		this.quantity = 1;
		this.totalPrice = 0;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		totalPrice = product.getPrice() * quantity;
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
