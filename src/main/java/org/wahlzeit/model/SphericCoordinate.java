/*
 * SphericCoordinate
 *
 * Version 1.2
 *
 * 03.12.2017
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

import org.wahlzeit.exceptions.IllegalSphericCoordinateStateException;
import org.wahlzeit.utils.DoubleUtil;

public class SphericCoordinate extends AbstractCoordinate {

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
		longitude = lon; 
		latitude = lat; 
		radius = rad;
		assertClassInvariants();
	}

	@Override
	protected CartesianCoordinate doAsCartesianCoordinate() {
		double x = radius*Math.sin(latitude)*Math.cos(longitude);
		double y = radius*Math.sin(latitude)*Math.sin(longitude);
		double z = radius*Math.cos(latitude);
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	protected SphericCoordinate doAsSphericCoordinate() {
		return this;
	}

	@Override
	protected double doGetDistance(Coordinate c) {
		return getSphericDistance(c);
	}

	@Override
	protected double doGetCartesianDistance(Coordinate c) {
		CartesianCoordinate sc = ((AbstractCoordinate) this).doAsCartesianCoordinate();
		return sc.getCartesianDistance(c);
	}


	@Override
	protected double doGetSphericDistance(Coordinate c) {
		SphericCoordinate sc = ((AbstractCoordinate) c).doAsSphericCoordinate();
		double angularStuff = Math.sin(latitude)*Math.sin(sc.latitude)*Math.cos(longitude-sc.longitude)+Math.cos(latitude)*Math.cos(sc.latitude);
		return Math.sqrt(radius*radius+sc.radius*sc.radius-2*radius*sc.radius*angularStuff);
	}

	@Override
	protected boolean doIsEqual(Coordinate c) {
		SphericCoordinate sc = ((AbstractCoordinate) c).doAsSphericCoordinate();

		if(DoubleUtil.isEqual(this.latitude, sc.latitude) && 
				DoubleUtil.isEqual(this.longitude, sc.longitude) &&
				DoubleUtil.isEqual(this.radius, sc.radius)) {
			return true;
		}

		return false;
	}

	/**
	 * @methodtype get
	 * @return the longitude
	 */
	public double getLongitude() {
		assertClassInvariants();
		double result = doGetLongitude();
		assertClassInvariants();
		return result;
	}
	protected double doGetLongitude() {
		return longitude;
	}

	/**
	 * @methodtype get
	 * @return the latitude
	 */
	public double getLatitude() {
		assertClassInvariants();
		double result = doGetLatitude();
		assertClassInvariants();
		return result;
	}
	protected double doGetLatitude() {
		return latitude;
	}

	/**
	 * @methodtype get
	 * @return the radius
	 */
	public double getRadius() {
		assertClassInvariants();
		double result = doGetRadius();
		assertClassInvariants();
		return result;
	}
	protected double doGetRadius() {
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

	@Override
	protected void assertClassInvariants() {
		
		if(!Double.isFinite(longitude) || longitude < 0 || longitude > 2*Math.PI) {
			throw new IllegalSphericCoordinateStateException(longitude,1);
		}
		
		if(!Double.isFinite(latitude) || latitude < 0 || latitude > Math.PI) {
			throw new IllegalSphericCoordinateStateException(latitude,2);
		}
		
		if(!Double.isFinite(radius) || radius < 0) {
			throw new IllegalSphericCoordinateStateException(radius,3);
		}

	}






}
