/*
 * CarManagerTest
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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarManagerTest {

	CarType golf;
	CarType passat;
	CarType VW;
	CarType gallardo;
	CarType lamborghini;
	
	CarManager manager;
	
	@Before
	public void setUp() throws Exception {
		golf = new CarType("Golf");
		golf.setManufacturer("VW");
		golf.setModelName("Golf");
		
		passat = new CarType("Passat");
		passat.setManufacturer("VW");
		passat.setModelName("Passat");
		
		gallardo = new CarType("Gallardo");
		gallardo.setManufacturer("Lamborghini");
		gallardo.setModelName("Gallardo");
		
		VW = new CarType("VW");
		VW.setManufacturer("VW");
		
		lamborghini = new CarType("Lamborghini");
		lamborghini.setManufacturer("Lamborghini");
		
		manager = CarManager.getInstance();
		
		manager.addCarType(VW);
		manager.addCarType(gallardo);
		manager.addCarType(golf);
		manager.addCarType(lamborghini);
		manager.addCarType(passat);
	}

	@Test
	public void testCreateCarAndGetCar() {
		manager.createCar("Lamborghini");
		Car res = manager.getCar(0);
		assertEquals(lamborghini,res.getCarType());
		
		manager.createCar("Passat");
		res = manager.getCar(1);
		assertEquals(passat,res.getCarType());
	}
	
	@Test
	public void testGetCarType() {
		assertEquals(golf,manager.getCarType("Golf"));
		assertEquals(passat,manager.getCarType("Passat"));
		assertEquals(lamborghini,manager.getCarType("Lamborghini"));
		assertEquals(null,manager.getCarType("Polo"));
		assertEquals(null,manager.getCarType(null));
	}
	
	@Test
	public void testGetInstance() {
		assertTrue(manager == CarManager.getInstance());
	}

}
