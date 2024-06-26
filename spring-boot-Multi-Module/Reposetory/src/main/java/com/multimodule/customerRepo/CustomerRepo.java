package com.multimodule.customerRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multimodule.customer.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{

}
