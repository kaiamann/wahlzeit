/*
 * Coordinate
 *
 * Version 2.0
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

import org.wahlzeit.exceptions.IllegalCoordinateStateException;

public interface Coordinate {

	/**
	 * @return the equivalent of this Coordinate in Cartesian representation
	 * @throws IllegalCoordinateStateException
	 */
	public CartesianCoordinate asCartesianCoordinate() throws IllegalCoordinateStateException;
	
	
	/**
	 * @return the equivalent of this Coordinate in Spheric representation
	 * @throws IllegalCoordinateStateException
	 */
	public SphericCoordinate asSphericCoordinate() throws IllegalCoordinateStateException;
	
	
	/**
	 * Computes and returns the Euclidean distance between two points in the Cartesian Coordinate system
	 * @param c the Coordinate to which the distance should be computed 
	 * @return the Euclidean distance
	 * @throws IllegalCoordinateStateException 
	 */
	public double getCartesianDistance(Coordinate c);
	
	/**
	 * Computes and returns the Spherical distance between two points in the Spherical Coordinate system
	 * @param c the Coordinate to which the distance should be computed 
	 * @return the spherical distance
	 * @throws IllegalCoordinateStateException 
	 */
	public double getSphericDistance(Coordinate c);
	
	/**
	 * Computes and returns the distance between two Coordinates
	 * @param c the Coordinate to which the distance should be computed 
	 * @return The spherical distance if this Coordinate is a SphericCoordinate,
	 * the Cartesian distance if this Coordinate is a CartesianCoordinate
	 * @throws IllegalCoordinateStateException 
	 */
	public double getDistance(Coordinate c);
	
	/**
	 * Compares this Coordinate to the given Coordinate c in terms of their x,y and z values.
	 * @param c the Coordinate to compare to
	 * @return true if the Coordinates are equal, false otherwise
	 * @throws IllegalCoordinateStateException 
	 * @methodtype boolean-query
	 */
	public boolean isEqual(Coordinate c);

}
