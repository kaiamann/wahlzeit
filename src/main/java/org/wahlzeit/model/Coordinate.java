package org.wahlzeit.model;

public class Coordinate {
private double x;
private double y;
private double z;

public Coordinate(double x,double y, double z) {
	this.x = x;
	this.y = y;
	this.z = z;
}

/**
 * @methodtype get
 */
public double getDistance(Coordinate c){
	double xdif = x - c.getX();
	double ydif = y - c.getY();
	double zdif = z - c.getZ();
	
	return Math.sqrt(xdif*xdif+ydif*ydif+zdif*zdif);
}

/**
 * @methodtype boolean-query
 */
public boolean isEqual(Coordinate c) {
	if(c.getX() == x && c.getY() == y && c.getZ() == z) {
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

/**
 * @methodtype boolean-query
 */
public boolean equals(Coordinate c) {
	return isEqual(c);
}

}
