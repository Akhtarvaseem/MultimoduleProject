package com.multimodule.productRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multimodule.product.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
  
	List<Product> findByCustomerId(int customerId);
}
