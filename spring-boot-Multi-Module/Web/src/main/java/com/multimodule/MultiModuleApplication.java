package com.multimodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.multimodule.*"})
@EntityScan(basePackages = {"com.multimodule.*"})
@EnableJpaRepositories(basePackages = {"com.multimodule.*"})
//@EnableDiscoveryClient
public class MultiModuleApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MultiModuleApplication.class);
	}
}
