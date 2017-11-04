/*
 * CoordinateTest
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

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

public class CoordinateTest {

	/**
	 * EPSILON for compensating floating point errors
	 */
	private static final double EPSILON = 1E-6;
	
	Coordinate c1 ,c2, c3, c4, c5;
	
	@Before
	public void setUp() throws Exception {
		c1 = new Coordinate(0,0,0);
		c2 = new Coordinate(1,0,0);
		c3 = new Coordinate(0,2,0);
		c4 = new Coordinate(4,5,6);
		c5 = new Coordinate(0,0,0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetDistance() {
		assertEquals(c1.getDistance(c2),1,EPSILON);
		assertEquals(c1.getDistance(c3),2,EPSILON);
		assertEquals(c1.getDistance(c4),Math.sqrt(4*4+5*5+6*6),EPSILON);
		
		c1.getDistance(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsEqual() {
		assertTrue(c1.isEqual(c1));
		assertTrue(c1.isEqual(c5));
		
		assertFalse(c1.isEqual(c2));
		
		c1.isEqual(null);
	}
	
	@Test
	public void testEquals() {
		assertTrue(c1.equals(c1));
		assertTrue(c1.equals(c5));
		
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(null));
	}
	
	@Test
	public void testGetters() {
		assertEquals(c4.getX(),4,EPSILON);
		assertEquals(c4.getY(),5,EPSILON);
		assertEquals(c4.getZ(),6,EPSILON);
	}

}
