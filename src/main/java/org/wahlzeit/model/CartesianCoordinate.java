/*
 * CartesianCoordinate
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

import org.wahlzeit.utils.DoubleUtil;

public class CartesianCoordinate extends AbstractCoordinate {

	/**
	 * Values for the Cartesian Coordinate System
	 */
	private double x;
	private double y;
	private double z;

	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x,double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
	}

	@Override
	protected CartesianCoordinate doAsCartesianCoordinate() {
		return this;
	}
	
	@Override
	protected SphericCoordinate doAsSphericCoordinate() {
		double radius = Math.sqrt(x*x+y*y+z*z);
		double latitude = radius != 0 ? Math.acos(z/radius) : 0;
		double longitude = Math.atan2(y, x);
		return new SphericCoordinate(longitude,latitude,radius);
	}

	@Override
	protected double doGetDistance(Coordinate c) {
		return getCartesianDistance(c);
	}	
	
	@Override
	protected double doGetCartesianDistance(Coordinate c){
		CartesianCoordinate cc = c.asCartesianCoordinate();

		double xdif = this.x - cc.x;
		double ydif = this.y - cc.y;
		double zdif = this.z - cc.z;

		return Math.sqrt(xdif*xdif+ydif*ydif+zdif*zdif);
	}

	@Override
	protected double doGetSphericDistance(Coordinate c) {
		return getDistance(c);
	}
	
	@Override
	protected boolean doIsEqual(Coordinate c) {
		CartesianCoordinate cc = c.asCartesianCoordinate();

		if(DoubleUtil.isEqual(this.x, cc.x) && 
				DoubleUtil.isEqual(this.y, cc.y) && 
				DoubleUtil.isEqual(this.z, cc.z)) {
			return true;
		}

		return false;
	}
	
	
	/**
	 * @methodtype get
	 * @return the radius
	 */
	public double getX() {
		assertClassInvariants();
		double result = doGetX();
		assertClassInvariants();
		return result;
	}
	protected double doGetX() {
		return x;
	}

	
	/**
	 * @methodtype get
	 * @return the radius
	 */
	public double getY() {
		assertClassInvariants();
		double result = doGetY();
		assertClassInvariants();
		return result;
	}
	protected double doGetY() {
		return y;
	}

	
	/**
	 * @methodtype get
	 * @return the radius
	 */
	public double getZ() {
		assertClassInvariants();
		double result = doGetZ();
		assertClassInvariants();
		return result;
	}
	protected double doGetZ() {
		return z;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 11;
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
	protected void assertClassInvariants() {
		if(Double.isNaN(x)) {
			throw new IllegalStateException("x is NaN!");
		}
		if(Double.isNaN(y)) {
			throw new IllegalStateException("y is NaN!");
		}
		if(Double.isNaN(z)) {
			throw new IllegalStateException("z is NaN!");
		}
		
	}
}
