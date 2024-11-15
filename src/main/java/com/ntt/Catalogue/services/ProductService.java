package com.ntt.Catalogue.services;


import java.util.List;
import org.springframework.stereotype.Service;
import com.ntt.Catalogue.models.Product;
import com.ntt.Catalogue.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
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
