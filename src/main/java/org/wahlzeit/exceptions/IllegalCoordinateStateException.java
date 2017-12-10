package org.wahlzeit.exceptions;

import org.wahlzeit.model.AbstractCoordinate;
import org.wahlzeit.model.CartesianCoordinate;
import org.wahlzeit.model.SphericCoordinate;


public class IllegalCoordinateStateException extends Exception {

	/**
	 * dunno what this is for but apparently it's important
	 */
	private static final long serialVersionUID = -2126893927048638750L;

	protected Class<? extends AbstractCoordinate> classOfOccurence;
	
	protected double invalidComponentValue;
	/**
	 * invalidComponent number: the value the invalidComponentValue represents 
	 * in the respective Cartesian and SphericCoordinate classes
	 * format: CartestianCoordinate / SphericCoordinate
	 * 1 for x / longitude
	 * 2 for y / latitude
	 * 3 for z / radius
	 */
	protected int invalidComponentNumber;
	
	/**
	 * @param invalidComponentValue the value of the component that causes this exception
	 * @param invalidComponentNumber the component the invalidComponentValue represents
	 * @param classOfOccurence  class of the Coordinate that produced this exception
	 */
	public IllegalCoordinateStateException(double invalidComponentValue,int invalidComponentNumber, Class<? extends AbstractCoordinate> classOfOccurence) {
		super("Invalid state in "+classOfOccurence.getName()+"!");

		this.classOfOccurence = classOfOccurence;
		this.invalidComponentValue = invalidComponentValue;
		this.invalidComponentNumber = invalidComponentNumber;
	}
	
	/**
	 * @param invalidComponentValue the value of the component that causes this exception
	 * @param invalidComponentNumber the value the invalidComponentValue represents
	 * @param classOfOccurence  class of the Coordinate that produced this exception
	 * @param cause preceding exception that led to this exception
	 */
	public IllegalCoordinateStateException(double invalidComponentValue,int invalidComponentNumber, Class<? extends AbstractCoordinate> classOfOccurence,Throwable cause) {
		super("Invalid state in a "+classOfOccurence,cause);

		this.classOfOccurence = classOfOccurence;
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
		if(classOfOccurence.isAssignableFrom(CartesianCoordinate.class)) {
			switch(invalidComponentNumber) {
				case 1: message += " Cause: x has value "+invalidComponentValue; break;
				case 2: message += " Cause: y has value "+invalidComponentValue; break;
				case 3: message += " Cause: x has value "+invalidComponentValue; break;
			}
		}
		
		if(classOfOccurence.isAssignableFrom(SphericCoordinate.class)) {
			switch(invalidComponentNumber) {
				case 1: message += " Cause: longitude has value "+invalidComponentValue; break;
				case 2: message += " Cause: latitude has value "+invalidComponentValue; break;
				case 3: message += " Cause: radius has value "+invalidComponentValue; break;
			}
			
		}
		return message;
	}



}
