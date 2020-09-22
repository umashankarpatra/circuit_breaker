package com.uma.circuit_breaker.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate getRestTemplateInstance() {
		return new RestTemplate();
	}

}
