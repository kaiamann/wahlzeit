/*
 * Coordinate
 *
 * Version 1.1
 *
 * 04.11.2017
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

public class Coordinate {

	/**
	 * EPSILON for compensating floating point errors
	 */
	private static final double EPSILON = 1e-6;

	/**
	 * Values for the Cartesian Coordinate System
	 */
	private double x;
	private double y;
	private double z;

	/**
	 * @methodtype constructor
	 */
	public Coordinate(double x,double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Computes and returns the Euclidean distance between two points in the Cartesian Coordinate system
	 * @param c the Coordinate to which the distance should be computed 
	 * @return the Euclidean distance
	 */
	public double getDistance(Coordinate c){
		if(c == null) {
			throw new IllegalArgumentException("Coordinate cannot be null!");
		}

		double xdif = this.x - c.x;
		double ydif = this.y - c.y;
		double zdif = this.z - c.z;

		return Math.sqrt(xdif*xdif+ydif*ydif+zdif*zdif);
	}

	/**
	 * Compares this Coordinate to the given Coordinate c in terms of their x,y and z values.
	 * @param c the Coordinate to compare to
	 * @return true if the Coordinates are equal, false otherwise
	 * @methodtype boolean-query
	 */
	public boolean isEqual(Coordinate c) {
		if(c == null) {
			throw new IllegalArgumentException("Coordinate cannot be null!");
		}

		double xdif = Math.abs(this.x - c.x);
		double ydif = Math.abs(this.y - c.y);
		double zdif = Math.abs(this.z - c.z);

		if(xdif < EPSILON && ydif < EPSILON && zdif < EPSILON) {
			return true;
		}

		return false;
	}

	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}

		if(obj == this){
			return true;
		}

		if(obj instanceof Coordinate){
			return this.isEqual((Coordinate) obj);
		}

		return false;

	}

}
