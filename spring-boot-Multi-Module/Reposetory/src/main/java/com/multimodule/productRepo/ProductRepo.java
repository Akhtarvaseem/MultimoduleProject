package com.multimodule.productRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multimodule.product.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
  
//	@Query(value = "SELECT p.name FROM Product p")      // when we use this query product convert string or Object type
	
	List<Product> findByCustomerId(int customerId);
}
