/*
 * IllegalCartesianCoordinateStateException
 *
 * Version 1.0
 *
 * 11.12.2017
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

package org.wahlzeit.exceptions;

import org.wahlzeit.model.AbstractCoordinate;

public class IllegalCartesianCoordinateStateException extends RuntimeException {
	
	/**
	 * dunno what this is for but apparently it's important
	 */
	private static final long serialVersionUID = 3745109390745891119L;
	
	static Class<? extends AbstractCoordinate> classOfOccurence = org.wahlzeit.model.CartesianCoordinate.class;
	
	protected double invalidComponentValue;
	/**
	 * invalidComponent number: the value the invalidComponentValue represents 
	 * 1 x
	 * 2 y
	 * 3 z
	 */
	protected int invalidComponentNumber;
	

	/**
	 * @param invalidComponentValue the value of the component that causes this exception
	 * @param invalidComponentNumber the component the invalidComponentValue represents
	 */
	public IllegalCartesianCoordinateStateException(double invalidComponentValue,int invalidComponentNumber) {
		super("Invalid state in "+classOfOccurence+"!");

		this.invalidComponentValue = invalidComponentValue;
		this.invalidComponentNumber = invalidComponentNumber;
	}

	/**
	 * @param invalidComponentValue the value of the component that causes this exception
	 * @param invalidComponentNumber the value the invalidComponentValue represents
	 * @param cause preceding exception that led to this exception
	 */
	public IllegalCartesianCoordinateStateException(double invalidComponentValue,int invalidComponentNumber,Throwable cause) {
		super("Invalid state in "+classOfOccurence+"!",cause);

		this.invalidComponentValue = invalidComponentValue;
		this.invalidComponentNumber = invalidComponentNumber;
	}


	/**
	 * @return the value of the component that produced this exception
	 */
	public double getInvalidComponentValue() {
		return invalidComponentValue;
	}

	/**
	 * @return the componentNumber of the component that produced this exception
	 */
	public int getInvalidComponentNumber() {
		return invalidComponentNumber;
	}
	
	/**
	 * @return returns the class of the Coordinate that produced this exception
	 */
	public Class<? extends AbstractCoordinate> getClassOfOccurence(){
		return classOfOccurence;
	}

	@Override
	public String getLocalizedMessage() {
		String message = super.getMessage();
		
		switch(invalidComponentNumber) {
			case 1: message += " Cause: x has value "+invalidComponentValue; break;
			case 2: message += " Cause: y has value "+invalidComponentValue; break;
			case 3: message += " Cause: x has value "+invalidComponentValue; break;
		}

		return message;
	}
}
