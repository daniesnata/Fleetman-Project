package com.virtualpairprogrammers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This application served as a tracker of moving vehicles
 * the coordinates will be retrieved from ActiveMQ and then supplied in REST call for other application to use
 */
@SpringBootApplication  
@EnableDiscoveryClient
public class PositionreceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionreceiverApplication.class, args);
	}
}