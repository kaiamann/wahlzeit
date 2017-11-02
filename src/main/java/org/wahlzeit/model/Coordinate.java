package org.wahlzeit.model;

public class Coordinate {

	/**
	 * EPSILON for compensating floating point errors
	 */
	private static final double EPSILON = 1E-6;
	
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
	
	@Override
	public String toString() {
		return "x: "+x+", y: "+y+", z: "+z;
	}

}
