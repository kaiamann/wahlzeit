/*
 * CarTypeTest
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

public class CarTypeTest {

	CarType golf;
	CarType passat;
	CarType VW;
	CarType gallardo;
	CarType lamborghini;
	
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
		
	}

	@Test
	public void testGetAttribute() {
		assertEquals("VW",golf.getArgument(0));
		assertEquals("Golf",golf.getArgument(1));
		
		assertEquals("VW",VW.getArgument(0));
	}
	
	@Test
	public void testIsSubtype() {
		assertTrue(golf.isSubtype(VW));
		assertTrue(passat.isSubtype(VW));
		assertFalse(VW.isSubtype(golf));
		assertFalse(golf.isSubtype(passat));
		// this is debatable but in my implementation a type cannot be subtype of itself
		assertFalse(passat.isSubtype(passat));
		assertFalse(golf.isSubtype(lamborghini));
		assertFalse(golf.isSubtype(gallardo));
	}

}
