package com.ntt.Catalogue.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ntt.Catalogue.models.Product;
import com.ntt.Catalogue.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	private static final int PAGE_SIZE = 5;
	
	public ProductService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
	public Page<Product> getProductsPage(Integer pageNumber){
		PageRequest pageRequest = PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");
		return productRepository.findAll(pageRequest);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}

