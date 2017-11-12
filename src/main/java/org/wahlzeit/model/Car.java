package org.wahlzeit.model;

public class Car {
	
	private int yearOfConstruction, wheelbase, length, width, height;
	private String manufacturer, modelName;
	private double curbWeight, kilowatts;
	
	public Car(String manufacturer, String modelName) {
		this.manufacturer = manufacturer;
		this.modelName = modelName;
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
	}

	/**
	 * @param yearOfConstruction the yearOfConstruction to set
	 */
	public void setYearOfConstruction(int yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}

	/**
	 * @param wheelbase the wheelbase to set
	 */
	public void setWheelbase(int wheelbase) {
		if(wheelbase <= 0) {
			throw new IllegalArgumentException("Wheelbase cannot be zero or negative!");
		}
		this.wheelbase = wheelbase;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		if(length <= 0) {
			throw new IllegalArgumentException("length cannot be zero or negative!");
		}
		this.length = length;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		if(width <= 0) {
			throw new IllegalArgumentException("Width cannot be zero or negative!");
		}
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		if(height <= 0) {
			throw new IllegalArgumentException("Height cannot be zero or negative!");
		}
		this.height = height;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * @param curbWeight the curbWeight to set
	 */
	public void setCurbWeight(double curbWeight) {
		if(curbWeight <= 0) {
			throw new IllegalArgumentException("Curb weight cannot be zero or negative!");
		}
		this.curbWeight = curbWeight;
	}

	
}
