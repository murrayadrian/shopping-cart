package com.vinh.dto;

import java.util.ArrayList;
import java.util.List;

import com.vinh.entity.Product;

public class ProductCart {
	
	private List<ProductItem> productItems;
	private double grandTotal;
	
	public ProductCart() {
		productItems = new ArrayList<>();
		this.grandTotal = 0;
	}
	public ProductItem findProductItem(Product product) {
		for(ProductItem productItem : productItems) {
			if(productItem.getProduct().getId() == product.getId()) {
				return productItem;
			}
		}
		return null;
	}
	
	public String addProductItem(Product product, int quantity) {
		ProductItem productItem = findProductItem(product);
		if(productItem != null) {
			if(product.getInstock() == 0) {
				return "Product out of stock";
			}
			else if(productItem.getQuantity() < productItem.getProduct().getInstock()) {
				productItem.setQuantity(productItem.getQuantity() + quantity);
				return "Add product successfully";
			}
			else {
				return "Product out of stock";			}
		}
		else if(productItem == null && product.getInstock() == 0) {
			return "Product out of stock";
		}
		else {
			productItem = new ProductItem(product);
			productItems.add(productItem);
			return "Add product successfully";
		}
	}
	
	public double getGrandTotal() {
		grandTotal = 0;
		for(ProductItem productItem :productItems) {
			grandTotal += productItem.getTotalPrice();
		}
		return grandTotal;
	}
	public List<ProductItem> getProductItems() {
		return productItems;
	}
	public void removeProductItem(Product product) {
		ProductItem productItem = findProductItem(product);
		if(productItem != null) {
			productItems.remove(productItem);
		}
	}
	public void clearProductItem() {
		productItems.clear();
	}
	public List<Product> checkout() {
		List<Product> products = new ArrayList<>();
		for(ProductItem productItem : productItems) {
			Product product = productItem.getProduct();
			product.setInstock(product.getInstock() - productItem.getQuantity());
			products.add(product);
		}
		productItems.clear();
		return products;
	}
}
