package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class CouponServicesApplication{
	
	//@Value("${test.properties}")
	//private String testProperty;

	public static void main(String[] args) {
		SpringApplication.run(CouponServicesApplication.class, args);
	}
	
	/*@GetMapping("/")
	public String getTestProperty() {
		return testProperty;
	}*/
	
	@GetMapping
	public String Hello(){
		return "Response from 1";
	}
	

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
