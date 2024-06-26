package com.multimodule.CustService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.multimodule.customExceptionWithinModule.ResourceNotFoundException;
import com.multimodule.customer.Customer;
import com.multimodule.customerRepo.CustomerRepo;
import com.multimodule.product.Product;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo repo;

	@Autowired
	RestTemplate restTemplate;

	public Customer saveCustDetails(Customer customer) {

		if (customer.getProduct() != null) {
			for (Product p : customer.getProduct()) {

				if (p != null) {

					ResponseEntity<Product> proRes = restTemplate.postForEntity("http://localhost:8080/product/save", p,
							Product.class);

				}
			}

		} 

		return repo.save(customer);


	}

	// find by id 
	public Customer getCustomer(int id) {
		
		Customer customer = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Something went wrong please check it again !"));
		
		
		 Product[] forObject = restTemplate.getForObject("http://localhost:8080/product/get/"+customer.getId(), Product[].class);

		List<Product> asList = Arrays.asList(forObject);
		
		
		for (Product product : asList) {
			if(product.getCustomerId()==id) {
				customer.setProduct(asList);
			}
			
		}
		
		return customer;
		
		
	}

	// update customer

	public Customer updateCustomer(Customer customer) {

		Customer customer2 = repo.findById(customer.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Id Not Found Please Chack Again !"));
		if (customer2 != null) {
			customer2.setName(customer.getName());
			customer2.setLocation(customer.getLocation());

			repo.save(customer2);

		}
		return customer2;

	}

	// delete by id
	public Boolean deleteProduct(int id) {

		Customer product2 = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id Not Found Please Chack Again !"));
		if (product2 != null) {

			repo.delete(product2);

			return true;
		}
		return false;

	}

	// getting all customer from database
	public List<Customer> getAllProduct() {
		Product[] listPro = restTemplate.getForObject("http://localhost:8080/product/get", Product[].class);

		List<Product> asList = Arrays.asList(listPro);
		
		System.out.println(listPro);

		List<Customer> ls = repo.findAll();
		
		
	

		for (Customer customer : ls) {
              
            	  
            	  customer.setProduct(asList);
              
		}

		return ls;
	}
}
