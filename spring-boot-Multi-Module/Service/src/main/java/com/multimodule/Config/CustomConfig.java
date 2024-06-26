package com.multimodule.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomConfig {

	@Bean
	RestTemplate getRestTemplate() {
	return new RestTemplate();
		
	}
	
}
