package com.vinh.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.vinh.dto.ProductCart;
import com.vinh.entity.Product;

public interface ProductService {
	public void saveProduct(Product product);
	
	public List<Product> getAllActiveProducts();
	
	public Optional<Product> getProductById(Long id);
	
	public ProductCart findProductCart(HttpSession session);
}
