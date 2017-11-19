package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

	/**
	 * EPSILON for compensating floating point errors
	 */
	private static final double EPSILON = 1e-6;

	/**
	 * Values for the Cartesian Coordinate System
	 */
	private double longitude;
	private double latitude;
	private double radius;

	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double lon,double lat, double rad) {
		if(lon > 2*Math.PI) {
			throw new IllegalArgumentException("Longitude cannot be over 360 Degreess!");
		}
		if(lon > 2*Math.PI) {
			throw new IllegalArgumentException("Latitude cannot be over 360 Degreess!");
		}
		longitude = lon; //azimuth phi
		latitude = lat; //inclination omega
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
	public double getDistance(Coordinate x) {
		if(x == null) {
			throw new IllegalArgumentException("Coordinate cannot be null!");
		}
		return getSphericDistance(x);
	}
	
	@Override
	public double getCartesianDistance(Coordinate x) {
		if(x == null) {
			throw new IllegalArgumentException("Coordinate cannot be null!");
		}
		CartesianCoordinate c = this.asCartesianCoordinate();
		return c.getCartesianDistance(x);
	}
	
	/**
	 * Computes and returns the Spherical distance between two points in the Spherical Coordinate system
	 * @param c the Coordinate to which the distance should be computed 
	 * @return the spherical distance
	 */
	@Override
	public double getSphericDistance(Coordinate x) {
		if(x == null) {
			throw new IllegalArgumentException("Coordinate cannot be null!");
		}
		SphericCoordinate c = x.asSphericCoordinate();
		double angularStuff = Math.sin(latitude)*Math.sin(c.latitude)*Math.cos(longitude-c.longitude)+Math.cos(latitude)*Math.cos(c.latitude);
		return Math.sqrt(radius*radius+c.radius*c.radius-2*radius*c.radius*angularStuff);
	}

	@Override
	public boolean isEqual(Coordinate x) {
		if(x == null) {
			throw new IllegalArgumentException("Coordinate cannot be null!");
		}
		SphericCoordinate c = x.asSphericCoordinate();

		double longdif = Math.abs(this.longitude - c.longitude);
		double latdif = Math.abs(this.latitude - c.latitude);
		double raddif = Math.abs(this.radius - c.radius);

		if(longdif < EPSILON && latdif < EPSILON && raddif < EPSILON) {
			return true;
		}

		return false;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
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
