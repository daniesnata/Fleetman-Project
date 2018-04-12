package com.virtualpairprogrammers.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtualpairprogrammers.controllers.Position;

/**
 * This class is used with Feign calling microservice
 */
@FeignClient(name = "fleetman-position-tracker")
public interface RemotePositionMicroservicesCalls {

	/**
	 * This method will get the vehicle data based on @param name from microservice 
	 * @param name, containing the name of the current vehicle
	 * @return Position, a custom class representing the position of the current vehicle
	 */
	@RequestMapping(method=RequestMethod.GET, value="/vehicles/{name}")
	public Position getLatestPositionForVehicle(@PathVariable("name") String name);
	
}
