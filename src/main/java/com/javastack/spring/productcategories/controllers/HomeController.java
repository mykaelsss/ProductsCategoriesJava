package com.javastack.spring.productcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javastack.spring.productcategories.models.Category;
import com.javastack.spring.productcategories.models.Product;
import com.javastack.spring.productcategories.services.CategoryService;
import com.javastack.spring.productcategories.services.ProductService;

@Controller
public class HomeController {

	private final ProductService productServ;
	private final CategoryService categoryServ;
	
	public HomeController(ProductService productServ, CategoryService categoryServ) {
		this.categoryServ = categoryServ;
		this.productServ = productServ;
	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productServ.allProducts());
		model.addAttribute("categories", categoryServ.allCategories());		
		return "home.jsp";
	}
	
	@GetMapping("/products/new")
	public String create(@ModelAttribute("product") Product product) {
		return "/products/create.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/create.jsp";
		}
		else {
			productServ.create(product);
			return "redirect:/";
		}
	}
	@GetMapping("/categories/new")
	public String create(@ModelAttribute("category") Category category) {
		return "/categories/create.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/create.jsp";
		}
		else {
			categoryServ.create(category);
			return "redirect:/";
		}
	}
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productServ.findById(id);
		model.addAttribute("assignedCategories", categoryServ.findAllProductCategories(product));
		model.addAttribute("unassignedCategories", categoryServ.findAllNotProductCategories(product));
		model.addAttribute("product", product);
		return "/products/show.jsp";
	}
	@PostMapping("/products/{id}")
	public String editProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long catId,  Model model) {
		Product product = productServ.findById(id);
		Category category = categoryServ.findById(catId);
		product.getCategories().add(category);
		productServ.update(product);
		model.addAttribute("assignedCategories", categoryServ.findAllProductCategories(product));
		model.addAttribute("unassignedCategories", categoryServ.findAllNotProductCategories(product));
		return "redirect:/products/" + id;
	}
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryServ.findById(id);
		model.addAttribute("assignedProducts", productServ.findAssignedProducts(category));
		model.addAttribute("unassignedProducts", productServ.findUnassignedProducts(category));
		model.addAttribute("category", category);
		return "/categories/show.jsp";
	}
	@PostMapping("/categories/{id}")
	public String editCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId,  Model model) {
		Category category = categoryServ.findById(id);
		Product product = productServ.findById(productId);
		category.getProducts().add(product);
		categoryServ.update(category);
		model.addAttribute("assignedProducts", productServ.findAssignedProducts(category));
		model.addAttribute("unassignedProducts", productServ.findUnassignedProducts(category));
		return "redirect:/categories/" + id;
	}
}
