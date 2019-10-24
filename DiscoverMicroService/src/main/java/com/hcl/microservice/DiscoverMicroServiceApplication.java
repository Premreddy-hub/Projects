package com.hcl.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoverMicroServiceApplication.class, args);
	}

}
