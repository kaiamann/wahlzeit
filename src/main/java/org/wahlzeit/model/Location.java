package org.wahlzeit.model;

public class Location {
public Coordinate coordinate = null;

/**
 * Constructor without arguments
 */
public Location() {	
}

/**
 * Constructor with Coordinate
 */
public Location(Coordinate c) {
	coordinate = c;
}

/**
 * Constructor with "raw" Coordinates
 */
public Location(double x,double y,double z) {
	coordinate = new Coordinate(x,y,z);
}

}
