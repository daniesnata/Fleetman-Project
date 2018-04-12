package com.virtualpairprogrammer.fleetmanglobalconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * This application will provide global config (properties) for each node of microservices
 * currently the git config is used, can be changed to local if needed
 * see application.properties for more details
 */
@SpringBootApplication
@EnableConfigServer
public class FleetmanGlobalConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetmanGlobalConfigApplication.class, args);
	}
}
