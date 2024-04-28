package com.grocery.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GroceryBookingApiGateWayRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryBookingApiGateWayRegistryApplication.class, args);
	}

}
