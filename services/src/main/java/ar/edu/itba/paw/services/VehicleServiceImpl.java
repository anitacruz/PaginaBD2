package ar.edu.itba.paw.services;

import java.util.Optional;

import ar.edu.itba.paw.interfaces.services.VehicleService;
import ar.edu.itba.paw.models.Location;
import ar.edu.itba.paw.models.Vehicle;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

	private static final String API_URL = "http://localhost:5000/";

	@Override
	public Optional<Vehicle> getNearbyLocations(long vehicleId) {
		Vehicle vehicle = null;

		//Hace una query a nuestra API para encontrar los negocios cercanos y la posición del vehículo dado el id
		try {
			JSONObject json = JsonReader.readJsonFromUrl(API_URL+vehicleId);
			System.out.println(json);
			vehicle = new Gson().fromJson(String.valueOf(json), Vehicle.class);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return Optional.ofNullable(vehicle);
	}
}