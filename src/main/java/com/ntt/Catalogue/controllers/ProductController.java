package com.ntt.Catalogue.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ntt.Catalogue.models.Category;
import com.ntt.Catalogue.models.Product;
import com.ntt.Catalogue.services.CategoryService;
import com.ntt.Catalogue.services.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	private ProductService productService;
	private CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
//	@GetMapping("/products/{pageNumber}")
//	public String getPage(@PathVariable Integer pageNumber, Model model) {
//		Page<Product> page = productService.getProductsPage(pageNumber);
//		int current = page.getNumber() + 1;
//		int begin = Math.max(1, current - 5);
//		int end = Math.min(begin + 10, page.getTotalPages());
//		
//		model.addAttribute("beginIndex",begin);
//		model.addAttribute("currentPage",current);
//		model.addAttribute("endIndex",end);
//		model.addAttribute("listProducts",page);
//		System.out.println("Begin: " + begin);
//		System.out.println("Current: " + current);
//		System.out.println("End: " + end);
//		System.out.println("Products: " + page.getContent());	
//		return "product";
//		
//	}
	
	@GetMapping("")
	public String getAll(Map<String, Object> model) {
		List<Product> allProducts = productService.getAllProducts();
		model.put("listProducts", allProducts);
		return "product";
	}
	
	@GetMapping("/add")
	public String addCategory(Map<String, Object> model)  {
		Product product = new Product();
		List<Product> allProducts = productService.getAllProducts();
		Category category = new  Category();
		List<Category> listCategories = categoryService.getAllCategories();
		model.put("listProducts", allProducts);
		model.put("product", product); 
		model.put("listCategories", listCategories);
		model.put("category",category);
		return "product"; 
	}
	
	
	
	
	@GetMapping("/{id}")
	public String getProductById(@PathVariable Long id, Map<String, Object> model) {
		List<Product> allProducts = productService.getAllProducts();
		Product product = productService.getProductById(id);
		model.put("product", product);
		model.put("listProducts",allProducts);
		return "product";
	}
	
	
	@GetMapping("edit/{id}")
	public String editProduct(@PathVariable Long id,Model model) {
		Product product = productService.getProductById(id);
		List<Product>  listProducts= productService.getAllProducts();
		List<Category> listCategories = categoryService.getAllCategories();
		model.addAttribute("listCategories",listCategories);
		model.addAttribute("listProducts",listProducts);
		model.addAttribute("product", product); 
		return "product";
	}

	
//	@PostMapping("/save")
//	public String saveProduct(Product product, Map<String, Object> model , final RedirectAttributes redirectAttributes) {
//		productService.save(product);
//		List<Product> allProducts = productService.getAllProducts();
//		model.put("listProducts",allProducts);
//		redirectAttributes.addFlashAttribute("message","Product Successfully Added");
//		return "redirect:/products";
//	}
	
	@PostMapping("/save")
	public String saveProduct(@RequestParam("file") MultipartFile file, Product product, Model model) {
	    try {
	        if (file.isEmpty()) {
	        	System.out.println("empty");
	        }
	        else {
	        	System.out.println("*********"+file.getOriginalFilename());
	            String uploadDir = System.getProperty("user.dir") + File.separator + "src" + File.separator+ "main"
	            		+ File.separator + "resources" + File.separator+ "static" +  File.separator+ "img" ; 
	            System.out.println("*************************" +uploadDir	);
	            String fileName = file.getOriginalFilename();
	            File uploadDirFile = new File(uploadDir);
	            
	            // Create directory if it doesn't exist
	            if (!uploadDirFile.exists()) {
	                uploadDirFile.mkdirs();
	            }

	            // Transfer the file to the destination folder
	            File dest = new File(uploadDir + fileName);
	            file.transferTo(dest);

	            // Set the file name to the photo field
	            product.setPhoto("/img/"+fileName);
	        }

	        // Save the product (this will save the photo field as the file name)
	        productService.save(product);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "redirect:/products"; // You can handle the error gracefully here
	    }
	    return "redirect:/products";  // Redirect to products page after saving
	}
 

	
	
	@GetMapping("/delete/{id}")
	public String deleteProductById(@PathVariable Long id,Map<String, Object> model, final RedirectAttributes redirectAttributes) {
		productService.delete(id);
		List<Product> allProducts = productService.getAllProducts();
		model.put("listProducts", allProducts);
		redirectAttributes.addFlashAttribute("message","Product Deleted Successfully");
		return "redirect:/products";
	}
	
	
}
