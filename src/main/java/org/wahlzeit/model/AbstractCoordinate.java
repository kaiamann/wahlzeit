/*
 * AbstractCoordinate
 *
 * Version 1.1
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

public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		CartesianCoordinate converted = this.doAsCartesianCoordinate();
		converted.assertClassInvariants();
		return converted;
	}
	protected abstract CartesianCoordinate doAsCartesianCoordinate() ;
	
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		SphericCoordinate converted = this.doAsSphericCoordinate();
		converted.assertClassInvariants();
		return converted;
	}
	protected abstract SphericCoordinate doAsSphericCoordinate();

	
	/**
	 * Computes and returns the Euclidean distance between two points in the Cartesian Coordinate system
	 * @param c the Coordinate to which the distance should be computed 
	 * @return the Euclidean distance
	 */
	@Override
	public double getCartesianDistance(Coordinate c) {
		assertClassInvariants();
		assertIsNonNullArgument(c);
		double result = this.doGetCartesianDistance(c);
		assertClassInvariants();
		return result;
	}
	protected abstract double doGetCartesianDistance(Coordinate c);

	
	/**
	 * Computes and returns the Spherical distance between two points in the Spherical Coordinate system
	 * @param c the Coordinate to which the distance should be computed 
	 * @return the spherical distance
	 */
	@Override
	public double getSphericDistance(Coordinate c) {
		assertClassInvariants();
		assertIsNonNullArgument(c);
		double result = this.doGetSphericDistance(c);
		assertClassInvariants();
		return result;
	}
	protected abstract double doGetSphericDistance(Coordinate c);

	
	@Override
	public double getDistance(Coordinate c) {
		assertClassInvariants();
		assertIsNonNullArgument(c);
		double result = this.doGetDistance(c);
		assertClassInvariants();
		return result;
	}
	protected abstract double doGetDistance(Coordinate c);

	/**
	 * Compares this Coordinate to the given Coordinate c in terms of their x,y and z values.
	 * @param c the Coordinate to compare to
	 * @return true if the Coordinates are equal, false otherwise
	 * @methodtype boolean-query
	 */
	@Override
	public boolean isEqual(Coordinate c) {
		assertClassInvariants();
		assertIsNonNullArgument(c);
		boolean result = this.doIsEqual(c);
		assertClassInvariants();
		return result;
	}
	protected abstract boolean doIsEqual(Coordinate c);
	
	
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
	
	
	protected abstract void assertClassInvariants();
	
	
	/**
	 * Checks if the given object obj is null and throws an IllegalArgumentException when it is
	 * @param obj
	 */
	protected void assertIsNonNullArgument(Object obj) {
		if(obj == null) {
			throw new IllegalArgumentException("Argument cannot be null!");
		}
	}


}
