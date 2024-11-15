package com.ntt.Catalogue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ntt.Catalogue.services.ProductService;

@Controller
public class ProductController {
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/save")
	public String saveProduct()
}
