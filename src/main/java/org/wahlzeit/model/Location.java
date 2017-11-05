/*
 * Location
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

public class Location {
	public Coordinate coordinate;

	/**
	 * Constructor without arguments
	 * @methodtype constructor
	 */
	public Location() {	
	}

	/**
	 * Constructor with Coordinate
	 * @methodtype constructor
	 */
	public Location(Coordinate c) {
		coordinate = c;
	}

	/**
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate c) {
		coordinate = c;
	}

	/**
	 * @methodtype get
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}


	@Override 
	public boolean equals(Object obj){
		if(obj == null) {
			return false;
		}

		if(obj == this) {
			return true;
		}

		if(obj instanceof Location) {
			return coordinate.isEqual(((Location) obj).getCoordinate());
		}

		return false;
	}

}
