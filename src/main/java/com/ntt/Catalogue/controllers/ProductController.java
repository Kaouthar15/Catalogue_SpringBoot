package com.ntt.Catalogue.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ntt.Catalogue.models.Category;
import com.ntt.Catalogue.models.Product;
import com.ntt.Catalogue.services.ProductService;




@Controller
@RequestMapping("products")
public class ProductController {
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("")
	public String getAll(Map<String, Object> model) {
		List<Product> allProducts = productService.getAllCategories();
		model.put("listProducts", allProducts);
		return "product";
	}
	
	@GetMapping("/add")
	public String addCategory(Map<String, Object> model)  {
		Product product = new Product();
		List<Product> allProducts = productService.getAllProducts();
		model.put("listProducts", allProducts);
		model.put("product", product); 
		return "product"; 
	}
	
	
	@PostMapping("/save")
	public String saveProduct(Product product, Map<String, Object> model , final RedirectAttributes redirectAttributes) {
		productService.save(product);
		List<Product> allProducts = productService.getAllProducts();
		model.put("listProducts",allProducts);
		redirectAttributes.addFlashAttribute("message","Product Successfully Added");
		return "redirect:/products";
	}
	
	@GetMapping("/{id}")
	public String getProductById(@PathVariable Long id, Map<String, Object> model) {
		List<Product> allProducts = productService.getAllProducts();
		Product product = productService.getProductById(id);
		model.put("product", product);
		model.put("listProducts",allProducts);
		return "product";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProductById(@PathVariable Long id,Map<String, Object> model, final RedirectAttributes redirectAttributes) {
		productService.delete(id);
		List<Product> allProducts = productService.getAllProducts();
		model.put("listProducts", allProducts);
		redirectAttributes.addFlashAttribute("message","Product Deleted Successfully");
		return "redirect:/products";
	}
	
	@GetMapping("/{pageNumber}") 
	public String getPage(@PathVariable Integer pageNumber, Model model) {
		Page<Product> page = productService.getProductsPage(pageNumber);
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());
		
		model.addAttribute("beginIndex",begin);
		model.addAttribute("currentPage",current);
		model.addAttribute("endIndex",end);
		model.addAttribute("listProducts",page);
		
		return "product";
		
	}
}
