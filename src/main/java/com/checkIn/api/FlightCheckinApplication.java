package com.checkIn.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FlightCheckinApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightCheckinApplication.class, args);
	}

}
