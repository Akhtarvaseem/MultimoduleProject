package com.multimodule.CustServiceInterface;

import java.util.List;

import com.multimodule.customer.Customer;

public interface CustomerService {

	// create user in database
	public Customer saveCustDetails(Customer customer) ;
	
	// find by id 
	public Customer getCustomer(int id) ;

	// update customer

	public Customer updateCustomer(Customer customer) ;
	// delete by id
	public Boolean deleteProduct(int id); 

	// getting all customer from database
	public List<Customer> getAllProduct() ;
}
