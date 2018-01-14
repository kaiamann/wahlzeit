/*
 * CarType
 *
 * Version 1.0
 *
 * 14.01.2017
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

public class CarType {

	// the name of this CarType
	private String name;
	private int yearOfConstruction, wheelbase, length, width, height;
	private String manufacturer, modelName;
	private double curbWeight, kilowatts;
	
	// this array lists the arguments above according to their generality and contains a true if the corresponding argument is set
	// indices of the arguments, starting with the most general one:
	// 0: manufacturer
	// 1: modelName
	// 2: yearOfConstruction
	// 3: wheelbase, 
	// 4: length
	// 5: width
	// 6: height
	// 7: curbWeight
	// 8: kilowatts
	private boolean[] priorityList = {false,false,false,false,false,false,false,false,false};
	
	public CarType(String name) {
		this.name = name;
	}
	
	/**
	 * @return an instance of this CarType
	 */
	public Car createInstance() {
		Car car = new Car(this);
		return car;
	}
	
	/**
	 * @return the name of the type
	 */
	public String getName() {
		return name;
	}
	
	// I don't know how to actually efficiently implement this, as there are too many possibilities in my domain....
	// e.g. when we're taking a VW Golf as a CarType then a possible supertype would be VW
	// so we can now conclude that the manufacturer as a type is always a supertype of a specific model
	// as a first attempt we could try to check if the attributes of the types are the same from the most general one down to
	// the most specific one. So if we now take a VW Passat as supertype argument and a Golf as "this" argument the check 
	// for this.manufacturer == supertype.manufacturer would return true, which would mean that 
	// VW Passat is a supertype of VW Golf which is obviously not correct
	// for this to be corrected we would have to check that all attributes of the supertype that are more specific 
	// than the manufacturer are left blank...
	// the problem here is that I would have to "number" my attributes according to their specificness, but since 
	// the attributes are all of different types I cannot use an array here or a simple getAttribute(int i) function...
	// I tried solving this problem by converting all numbers that occur to Strings, to actually use a getAttribute(i) function
	// combined with a priorityList... (I know that I probably don't need the priorityList like this, as its functionality 
	// could also be realized by simple == null checks etc.)
	// I'm pretty sure that I'm not getting all the relationships between the types right, but this is as close as I could get
	/**
	 * @param supertype
	 * @return true if this is a subtype of supertype, false otherwise
	 */
	public boolean isSubtype(CarType supertype) {
		boolean[] superPlist = supertype.getPriorityList();
		for(int i=0;i<priorityList.length;i++) {
			// if both supertype and this type have the ith attribute set, 
			// but they have different values this type cannot be a subtype of supertype
			if(priorityList[i] && superPlist[i] && !getArgument(i).equals(supertype.getArgument(i))) {
				return false;
			}
			// if both supertype and this type have the ith attribute set, 
			// and they have the same values this type could be a subtype of supertype
			if(priorityList[i] && superPlist[i] && getArgument(i).equals(supertype.getArgument(i))) {
				continue;
			}
			
			// if this type has the ith attribute set, but supertype doesn't, (that means supertype is less specific than this type)
			// this type is a subtype of supertype (since the second if-clause makes sure all attributes before are the same)
			if(priorityList[i] && !superPlist[i]) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * @param the index i
	 * @return the attribute at index i of the priorityList as String. If the attribute was a number and was
	 *  not set this returns null instead
	 */
	public String getArgument(int i) {
		switch(i) {
		case 0: return manufacturer;
		case 1: return modelName; 
		case 2: return yearOfConstruction == 0 ? null : new Integer(yearOfConstruction).toString();
		case 3: return wheelbase == 0 ? null : new Integer(wheelbase).toString();
		case 4: return length == 0 ? null : new Integer(length).toString();
		case 5: return width == 0 ? null : new Integer(width).toString();
		case 6: return height == 0 ? null : new Integer(height).toString();
		case 7: return curbWeight == 0 ? null : new Double(curbWeight).toString();
		case 8: return kilowatts == 0 ? null : new Double(kilowatts).toString();
		}
		return null;
	}
	
	/**
	 * @return the priority list
	 */
	public boolean[] getPriorityList() {
		return priorityList;
	}
	
	/**
	 * @return the horsepower
	 */
	public double getKilowatts() {
		return kilowatts;
	}

	/**
	 * @return the yearOfConstruction
	 */
	public int getYearOfConstruction() {
		return yearOfConstruction;
	}

	/**
	 * @return the wheelbase
	 */
	public int getWheelbase() {
		return wheelbase;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * @return the curbWeight
	 */
	public double getCurbWeight() {
		return curbWeight;
	}

	/**
	 * @param horsepower the horsepower to set
	 */
	public void setKilowatts(double kilowatts) {
		if(kilowatts <= 0) {
			throw new IllegalArgumentException("Kilowatts cannot be zero or negative!");
		}
		this.kilowatts = kilowatts;
		priorityList[8] = true;
	}

	/**
	 * @param yearOfConstruction the yearOfConstruction to set
	 */
	public void setYearOfConstruction(int yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
		priorityList[2] = true;
	}

	/**
	 * @param wheelbase the wheelbase to set
	 */
	public void setWheelbase(int wheelbase) {
		if(wheelbase <= 0) {
			throw new IllegalArgumentException("Wheelbase cannot be zero or negative!");
		}
		this.wheelbase = wheelbase;
		priorityList[3] = true;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		if(length <= 0) {
			throw new IllegalArgumentException("length cannot be zero or negative!");
		}
		this.length = length;
		priorityList[4] = true;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		if(width <= 0) {
			throw new IllegalArgumentException("Width cannot be zero or negative!");
		}
		this.width = width;
		priorityList[5] = true;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		if(height <= 0) {
			throw new IllegalArgumentException("Height cannot be zero or negative!");
		}
		this.height = height;
		priorityList[6] = true;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		priorityList[0] = true;
	}

	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
		priorityList[1] = true;
	}

	/**
	 * @param curbWeight the curbWeight to set
	 */
	public void setCurbWeight(double curbWeight) {
		if(curbWeight <= 0) {
			throw new IllegalArgumentException("Curb weight cannot be zero or negative!");
		}
		this.curbWeight = curbWeight;
		priorityList[7] = true;
	}
}
