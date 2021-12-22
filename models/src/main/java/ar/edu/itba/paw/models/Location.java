package ar.edu.itba.paw.models;

import java.awt.Point;
import java.util.List;

public class Location {
	private String name;
	private String amenity;
	private String website;
	private List<Float> position;
	private Float distance;

	public Location(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Float> getPosition() {
		return position;
	}

	public void setPosition(List<Float> position) {
		this.position = position;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}
}
