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
