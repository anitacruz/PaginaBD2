package ar.edu.itba.paw.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import ar.edu.itba.paw.interfaces.services.LocationService;
import ar.edu.itba.paw.models.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationServiceImpl implements LocationService {

	private static final String API_URL = "https://graph.facebook.com/19292868552";

	@Override
	public Vehicle getNearbyLocations(long vehicleId) {
		try {
			JSONObject json = JsonReader.readJsonFromUrl(API_URL);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}