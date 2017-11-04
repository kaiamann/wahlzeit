/*
 * LocationTest
 *
 * Version 1.1
 *
 * 04.11.2017
 *
 * Copyright (c) by Kai Amann
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

public class LocationTest {
	
	Location x,y,z;
	
	Coordinate c1,c2;

	@Before
	public void setUp() throws Exception {	
		c1 = new Coordinate(1,2,3);
		c2 = new Coordinate(1,1,1);
		
		x = new Location(c1);
		y = new Location(c2);
		z = new Location();
	}

	@Test
	public void testGetCoordinate() {
		assertEquals(x.getCoordinate(),c1);
		assertEquals(y.getCoordinate(),c2);
		assertEquals(z.getCoordinate(),null);
	}
	
	@Test
	public void testSetCoordinate() {
		x.setCoordinate(c2);
		assertEquals(x.getCoordinate(),c2);
		
		y.setCoordinate(c1);
		assertEquals(y.getCoordinate(),c1);
	}
	
	@Test
	public void testEquals() {
		assertTrue(x.equals(x));
		
		assertFalse(y.equals(x));
		
		y.setCoordinate(c1);
		assertTrue(y.equals(x));
	}
}
