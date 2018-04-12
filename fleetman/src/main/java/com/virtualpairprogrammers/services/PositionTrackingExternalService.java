package com.virtualpairprogrammers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.virtualpairprogrammers.controllers.Position;
import com.virtualpairprogrammers.data.VehicleRepository;
import com.virtualpairprogrammers.domain.Vehicle;

/**
 * This class were used to access the external service (microservices)
 */
@Service
public class PositionTrackingExternalService {
	
	@Autowired
	private VehicleRepository repository;
	
	@Autowired
	private RemotePositionMicroservicesCalls remoteService;
	
	
	@HystrixCommand(fallbackMethod="handleExternalServiceDown")
	public Position getLatestPositionForVehicleFromRemoteMicroservice(String name) {
		
		Position response = remoteService.getLatestPositionForVehicle(name);
		response.setUpToDate(true);
		
		return response;
	}
	

	/**
	 * Fallback method if any failure or exception occurred in getLatestPositionForVehicleFromRemoteMicroservice
	 */
	public Position handleExternalServiceDown(String name) {
		Position position = new Position();
		Vehicle vehicle = repository.findByName(name);
		position.setLat(vehicle.getLat());
		position.setLongitude(vehicle.getLongitude());
		position.setTimestamp(vehicle.getLastRecordedPosition());
		return position;
	}
}
