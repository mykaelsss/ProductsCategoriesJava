package com.javastack.spring.productcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.spring.productcategories.models.Category;
import com.javastack.spring.productcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findAll();
	Optional<Product> findById(Long id);
	
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
	
}
