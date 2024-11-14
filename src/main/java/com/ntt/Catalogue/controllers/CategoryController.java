package com.ntt.Catalogue.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/{id}")
	public String getCategoryById(@PathVariable Long id, Map<String, Object> model) {
		Category category = categoryService.getCategoryById(id);
		List<Category> allCategories = categoryService.getAllCategories();
		model.put("category", category);
		model.put("listCategories", allCategories);
		return "category";
	} 
	
	@PostMapping(value = "/save")
	public String saveCategory(Category category, Map<String, Object> model, final RedirectAttributes redirectAttributes) {
		categoryService.save(category);
		List<Category> allCategories = categoryService.getAllCategories();
		model.put("listCategories",allCategories); 
		redirectAttributes.addFlashAttribute("message","Category Saved Successfully !");
		return "redirect:/category";
	}
	
	@PostMapping(value = "/delete")
	public String deleteCategory(@RequestParam Long id, Map<String, Object> model, final RedirectAttributes redirectAttributes) {
		categoryService.delete(id);
		List<Category> allCategories = categoryService.getAllCategories();
		model.put("listCategories", allCategories);
		redirectAttributes.addFlashAttribute("message","Category Deleted Successfully !");
		return "redirect:/category";
	}
	
	
	

}
