package ar.edu.itba.paw.interfaces.services;

import ar.edu.itba.paw.models.Vehicle;

public interface LocationService {
	//Devuelve el vehículo y las ubicaciones cercanas
	Vehicle getNearbyLocations(long vehicleId);
}
