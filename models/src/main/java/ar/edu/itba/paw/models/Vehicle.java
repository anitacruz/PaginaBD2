package ar.edu.itba.paw.models;

import java.awt.*;

public class Vehicle {
	private Long id;
	private Point position;
	private Location[] near;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Location[] getNear() {
		return near;
	}

	public void setNear(Location[] near) {
		this.near = near;
	}
}
