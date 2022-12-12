package com.javastack.spring.productcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javastack.spring.productcategories.models.Category;
import com.javastack.spring.productcategories.models.Product;
import com.javastack.spring.productcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	//Find all 
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	//Find one
	public Category showCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return optionalCategory.orElse(null);
		}
	}
	
	//Create
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	
	//Update
	public Category update(Category category) {
		return categoryRepo.save(category);
	}
	
	//Delete
	public void delete(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			categoryRepo.deleteById(id);
		}
	}
	
	public List<Category> findAllProductCategories(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> findAllNotProductCategories(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
}
