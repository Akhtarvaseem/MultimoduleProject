package com.multimodule.ProServiceInterface;

import java.util.List;

import com.multimodule.product.Product;

public interface ProductService {
//	 creating object and store in database
	public Product saveProduct(Product product);

	// get ById
	public List<Product> getProduct(int id);

	// update product

	public Product updateProduct(Product product);

	// delete by id
	public Boolean deleteProduct(int id);

	// getting all product from database
	public List<Product> getAllProduct();
}
