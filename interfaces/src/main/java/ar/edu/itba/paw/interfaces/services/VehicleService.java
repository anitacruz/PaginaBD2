package ar.edu.itba.paw.interfaces.services;

import ar.edu.itba.paw.models.Vehicle;

import java.util.Optional;

public interface VehicleService {
	//Devuelve el vehículo y las ubicaciones cercanas
	Optional<Vehicle> getNearbyLocations(long vehicleId);
}
