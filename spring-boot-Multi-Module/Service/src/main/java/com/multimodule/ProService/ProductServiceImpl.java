package com.multimodule.ProService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multimodule.ProServiceInterface.ProductService;
import com.multimodule.customExceptionWithinModule.ResourceNotFoundException;
import com.multimodule.product.Product;
import com.multimodule.productRepo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
  final	ProductRepo repo;
	
	
	public ProductServiceImpl(ProductRepo repo) {
	 this.repo=repo;
	}

    // creating object and store in database
	public Product saveProduct(Product product) {

		return repo.save(product);
	}
	
	
	
	// get ById 
	public List<Product> getProduct(int id ) {
		
		List<Product> product = repo.findByCustomerId(id);
		if(product==null) {
			throw new ResourceNotFoundException("Something went wrong please check it again !");
		}else {
			
			return  product;
		}
	}
	
	
	// update product

	public Product updateProduct(Product product) {

		Product product2 = repo.findById(product.getId()).orElseThrow(()-> new ResourceNotFoundException("Id Not Found Please Chack Again !"));
		if (product2 != null) {
			product2.setName(product.getName());
			product2.setType(product.getType());

			repo.save(product2);

		}
		return product2;

	}
	
	// delete by id
	public Boolean deleteProduct(int id) {
		
		Product product2 = repo.findById(id ).orElseThrow(()-> new ResourceNotFoundException("Id Not Found Please Chack Again !"));
		if (product2 != null) {

			repo.delete(product2);
			
			return true; 
		}
		return false;
		
	}
	
	
	
	// getting all product from database 
	public List<Product> getAllProduct(){
		
		return repo.findAll();
	}
	
	
}
