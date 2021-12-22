package ar.edu.itba.paw.models;

import java.awt.Point;
import java.util.List;

public class Vehicle {

	private Long vehicleId;
	private List<Float> position;
	private List<Location> near;

	public Vehicle(){}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
/*
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
*/

	public List<Float> getPosition() {
		return position;
	}

	public void setPosition(List<Float> position) {
		this.position = position;
	}

	public List<Location> getNear() {
		return near;
	}

	public void setNear(List<Location> near) {
		this.near = near;
	}

}
