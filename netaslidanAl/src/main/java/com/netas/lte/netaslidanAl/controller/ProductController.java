package com.netas.lte.netaslidanAl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netas.lte.netaslidanAl.entity.Product;
import com.netas.lte.netaslidanAl.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("api/products")
	public ResponseEntity<?> findAllProducts() {
		
		try {
			List<Product> products = productRepository.findAll();
			return ResponseEntity.ok(products);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("api/products/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		try {
			
			Optional<Product> product = productRepository.findById(id);
			return ResponseEntity.ok(product);
			
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
