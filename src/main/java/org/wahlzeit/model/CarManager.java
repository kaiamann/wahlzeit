/*
 * CarManager
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

import java.util.HashMap;

public class CarManager {

	// running variable that gives us the next free identifier for the Car instances
	private int nextFreeId = 0;
	
	// static CarManager instance (should probably be final, but since it's private and I don't have any methods that change this field)
	private static CarManager instance = null;
	
	// hashMaps to store the Cars and CarTypes
	private HashMap<Integer,Car> cars;
	private HashMap<String,CarType> carTypes;
	
	// I implemented the Manager as a Singleton, hence the private constructor and the getInstance method
	private CarManager() {
		cars = new HashMap<Integer,Car>();
		carTypes = new HashMap<String,CarType>();
	}
	
	/**
	 * @return the CarManager instance. If none exists when this method is called a new CarManager is 
	 * instantiated and returned.
	 */
	public synchronized static CarManager getInstance() {
		if(instance == null) {
			instance = new CarManager();
		}
		return instance;
	}
	
	public Car createCar(String typeName) {
		assertIsValidCarType(typeName);
		CarType ct = getCarType(typeName);
		Car result = ct.createInstance();
		cars.put(result.getId(),result);
		return result;
	}
	
	/**
	 * @return the next free Id
	 */
	public void addCarType(CarType carType) {
		carTypes.put(carType.getName(), carType);
	}
	
	/**
	 * @return the next free Id
	 */
	public synchronized int getNextId() {
		int res = nextFreeId;
		nextFreeId++;
		return res;
	}
	
	
	/**
	 * @param typeName
	 * @return the CarType instance that belongs to the typeName identifier
	 */
	public CarType getCarType(String typeName) {
		return carTypes.get(typeName);
	}
	
	/**
	 * @param typeName
	 * @return the Car instance that belongs to the id
	 */
	public Car getCar(int id) {
		return cars.get(id);
	}
	
	/**
	 * makes sure the given typeName identifier describes an existing CarType
	 * @param typeName
	 */
	public void assertIsValidCarType(String typeName) {
		if(carTypes.get(typeName) == null) {
			throw new IllegalArgumentException("Invalid type name!");
		}
	}
}
