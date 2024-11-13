package com.ntt.Catalogue.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntt.Catalogue.models.Category;
import com.ntt.Catalogue.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("")
	public String getAll(Map<String, Object> model) {
		List<Category> allCategories = categoryService.getAllCategories();
		model.put("listCategories", allCategories);
		return "category";
	}
	

}
