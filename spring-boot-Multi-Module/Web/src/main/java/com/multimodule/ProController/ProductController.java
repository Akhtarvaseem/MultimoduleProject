package com.multimodule.ProController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multimodule.ProService.ProductServiceImpl;
import com.multimodule.product.Product;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl service;

	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product saveProduct = service.saveProduct(product);
		if(saveProduct!=null) {
		return   ResponseEntity.status(HttpStatus.OK).body( saveProduct);            
		}
		return  ResponseEntity.status(HttpStatus.OK).body(saveProduct);
		
	}
	
	@GetMapping("get/{id}")
	public List<Product> getProduct(@PathVariable int id ) {
		
		return service.getProduct(id);
		
	}
	
	// update product

    @PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {

		Product product2 = service.updateProduct(product);
		if (product2 != null) {
			

			return product2;

		}
		return product2;

	}
	
	// delete by id
    @DeleteMapping("delete/{id}")
	public Boolean deleteProduct(@PathVariable int id) {
		
	boolean deleteProduct = service.deleteProduct(id);
		if (deleteProduct == true) {

			
			
			return true; 
		}
		return false;
		
	}
	
	
	
	// getting all product from database 
	@GetMapping("/get")
	public List<Product> getAllProduct(){
		
		return service.getAllProduct();
	}
	
}
