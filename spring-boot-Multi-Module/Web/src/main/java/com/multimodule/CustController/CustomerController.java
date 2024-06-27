package com.multimodule.CustController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multimodule.CustService.CustomerServiceImpl;
import com.multimodule.customer.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl service;
	
	
	@PostMapping("/save")
	public String saveCustomer(@RequestBody Customer customer) {
		
		
		Customer saveCustDetails = service.saveCustDetails(customer);
		if(saveCustDetails!=null) {
			return "successfully inserted";
			}
			return "something went wrong ";
	}
	
	
	@GetMapping("get/{id}")
	public Customer getCustomer(@PathVariable int id) {
		
		Customer customer = service.getCustomer(id);
		return customer;
	}
	
	
	
	// update customer
	@PutMapping("/update")
		public String updateCustomer(@RequestBody Customer customer) {

			Customer updateCustomer = service.updateCustomer(customer);
			if(updateCustomer!=null) {
				
				return "update suceessfull";
			}
			return "updation faild";
			

		}
		
		// delete by id
	@DeleteMapping("delete/{id}")
		public Boolean deleteProduct(@PathVariable int id) {
			
			Boolean deleteProduct = service.deleteProduct(id);
			if (deleteProduct==true) {

				
				return true; 
			}
			return false;
			
		}
		
		
		
		// getting all customer from database 
	
	   @GetMapping("/get")
		public List<Customer> getAllProduct(){
			
			return service.getAllProduct();
		}
}
