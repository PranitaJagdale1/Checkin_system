package com.checkIn.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class FlightCheckinApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightCheckinApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
