package com.vinh.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinh.dto.ProductCart;
import com.vinh.entity.Product;
import com.vinh.repository.ProductRepository;
import com.vinh.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> getAllActiveProducts() {
		return productRepository.findAll();
	}
	
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}
	public ProductCart findProductCart(HttpSession session) {
		ProductCart productCart = (ProductCart) session.getAttribute("productCart");
		if(productCart == null) {
			productCart = new ProductCart();
			session.setAttribute("productCart", productCart);
		}
		return productCart;
	}
	public void removeCart(HttpSession session) {
		session.removeAttribute("productCart");
	}
}
