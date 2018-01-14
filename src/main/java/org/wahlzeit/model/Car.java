/*
 * CarPhoto
 *
 * Version 2.0
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

public class Car {
	
	private int  id;
	protected CarType type = null;
	private CarManager manager;
	
	
	public Car(CarType type) {
		manager = CarManager.getInstance();
		id = manager.getNextId();
		this.type = type;
	}
	
	public int getId(){
		return id;
	}
	
	public CarType getCarType() {
		return type;
	}
}
