/*
 * SphericCoordinate
 *
 * Version 1.1
 *
 * 25.11.2017
 *
 * Copyright (c) 2107 by Kai Amann, https://github.com/kaiamann
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

	/**
	 * EPSILON for compensating floating point errors
	 */
	private static final double EPSILON = 1e-6;

	/**
	 * Values for the Spheric Coordinate System
	 */
	// azimuth phi
	private double longitude;
	// inclination omega
	private double latitude;
	// radius
	private double radius;

	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double lon,double lat, double rad) {
		if(lon > 2*Math.PI) {
			throw new IllegalArgumentException("Longitude cannot be over 360 degrees!");
		}
		if(lon > 2*Math.PI) {
			throw new IllegalArgumentException("Latitude cannot be over 360 degrees!");
		}
		longitude = lon; 
		latitude = lat; 
		radius = rad;
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius*Math.sin(latitude)*Math.cos(longitude);
		double y = radius*Math.sin(latitude)*Math.sin(longitude);
		double z = radius*Math.cos(latitude);
		return new CartesianCoordinate(x,y,z);
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getDistance(Coordinate c) {
		super.getDistance(c);
		return getSphericDistance(c);
	}
	
	@Override
	public double getCartesianDistance(Coordinate c) {
		super.getCartesianDistance(c);
		CartesianCoordinate sc = this.asCartesianCoordinate();
		return sc.getCartesianDistance(c);
	}
	
	/**
	 * Computes and returns the Spherical distance between two points in the Spherical Coordinate system
	 * @param c the Coordinate to which the distance should be computed 
	 * @return the spherical distance
	 */
	@Override
	public double getSphericDistance(Coordinate c) {
		super.getSphericDistance(c);
		SphericCoordinate sc = c.asSphericCoordinate();
		double angularStuff = Math.sin(latitude)*Math.sin(sc.latitude)*Math.cos(longitude-sc.longitude)+Math.cos(latitude)*Math.cos(sc.latitude);
		return Math.sqrt(radius*radius+sc.radius*sc.radius-2*radius*sc.radius*angularStuff);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		boolean res = super.isEqual(c);
		if(res) {
			return res;
		}
		
		SphericCoordinate sc = c.asSphericCoordinate();

		double longdif = Math.abs(this.longitude - sc.longitude);
		double latdif = Math.abs(this.latitude - sc.latitude);
		double raddif = Math.abs(this.radius - sc.radius);

		if(longdif < EPSILON && latdif < EPSILON && raddif < EPSILON) {
			return true;
		}

		return false;
	}

	/**
	 * @methodtype get
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @methodtype get
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @methodtype get
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = super.equals(obj);
		if(res) {
			return res;
		}

		if(obj instanceof Coordinate){
			return this.isEqual((Coordinate) obj);
		}

		return false;

	}

	
	
	

}
