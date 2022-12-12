package com.javastack.spring.productcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javastack.spring.productcategories.models.Category;
import com.javastack.spring.productcategories.models.Product;
import com.javastack.spring.productcategories.repositories.ProductRepository;

@Service
public class ProductService {

	
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	//Find all 
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	//Find one
	public Product showProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return optionalProduct.orElse(null);
		}
	}
	
	//Create
	public Product create(Product product) {
		return productRepo.save(product);
	}
	
	//Update
	public Product update(Product product) {
		return productRepo.save(product);
	}
	
	//Delete
	public void delete(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			productRepo.deleteById(id);
		}
	}
	public Product findById(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	
	public List<Product> findAssignedProducts(Category category){
		return productRepo.findAllByCategories(category);
	}
	public List<Product> findUnassignedProducts(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
}
