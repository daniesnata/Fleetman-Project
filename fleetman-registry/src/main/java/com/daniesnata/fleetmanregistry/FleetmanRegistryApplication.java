package com.daniesnata.fleetmanregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * This application enable Eureka server only
 */
@SpringBootApplication
@EnableEurekaServer
public class FleetmanRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetmanRegistryApplication.class, args);
	}   
}
