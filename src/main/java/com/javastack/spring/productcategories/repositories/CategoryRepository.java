package com.javastack.spring.productcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javastack.spring.productcategories.models.Category;
import com.javastack.spring.productcategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);
    
    List<Category> findAll();
}
