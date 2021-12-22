package ar.edu.itba.paw.models;

import java.awt.*;

public class Location {
	private String name;
	private String amenity;
	private Point position;
	private Float distance;

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

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}
}
