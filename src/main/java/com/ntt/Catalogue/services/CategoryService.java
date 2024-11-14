package com.ntt.Catalogue.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntt.Catalogue.models.Category;
import com.ntt.Catalogue.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).get(); 
	}
	
	public void delete(Long id) {
		categoryRepository.deleteById(id); 
	}
	

	
	
}
