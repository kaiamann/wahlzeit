/*
 * CoordinateTest
 *
 * Version 2.1
 *
 * 25.11.2017
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


public class CoordinateTest {

	/**
	 * EPSILON for compensating floating point errors
	 */
	private static final double EPSILON = 1e-6;

	Coordinate c1 ,c2, c3, c4, c5, s1, s2, s3, s4, s5;

	@Before
	public void setUp() throws Exception {
		c1 = new CartesianCoordinate(0,0,0);
		c2 = new CartesianCoordinate(0,0,1);
		c3 = new CartesianCoordinate(0,2,0);
		c4 = new CartesianCoordinate(4,5,6);
		c5 = new CartesianCoordinate(0,0,0);

		s1 = new SphericCoordinate(0, 0, 0); // = c1 
		s2 = new SphericCoordinate(0, 0, 1); // = c2
		s3 = new SphericCoordinate(2.2324,1.345d, 34);
		s4 = new SphericCoordinate(Math.PI,1.512d, 12);
		s5 = new SphericCoordinate(2.2324,1.345d, 34);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceCartesianCartesian() {
		// Testing the distances between cartesian coordinates
		assertEquals(1,c1.getDistance(c2),EPSILON);
		assertEquals(2,c1.getDistance(c3),EPSILON);
		assertEquals(Math.sqrt(4*4+5*5+6*6),c1.getDistance(c4),EPSILON);

		// Testing for invalid input
		c1.getDistance(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceSphericalSpherical() {
		// Testing the distances between cartesian coordinates
		assertEquals(1,s1.getDistance(s2),EPSILON);

		// Testing for invalid input
		s1.getDistance(null);
	}

	@Test
	public void testGetDistanceCartesianSpherical() {
		// Testing the distances between cartesian and cartesian coordinates
		assertEquals(1,c1.getDistance(s2),EPSILON);
	}

	@Test
	public void testGetDistanceSphericalCartesian() {
		// Testing the distances between spherical and cartesian coordinates
		assertEquals(2,s1.getDistance(c3),EPSILON);
	}

	// Testing converting into the other format and back again
	@Test
	public void testConversions() {
		// converting from cartesian to spheric ad back
		SphericCoordinate s = c1.asSphericCoordinate();
		assertTrue(s.asCartesianCoordinate().isEqual(c1));

		s = c4.asSphericCoordinate();
		assertTrue(s.asCartesianCoordinate().isEqual(c4));

		
		// converting from spheric to cartesian and back
		CartesianCoordinate c = s3.asCartesianCoordinate();
		assertTrue(c.asSphericCoordinate().isEqual(s3));

		c = s4.asCartesianCoordinate();
		assertTrue(c.asSphericCoordinate().isEqual(s4));
	}

	@Test
	public void testGetDistanceAndConversions() {
		// testing if distances computed from both sides are the same
		double distanceCartesianToSpherical = c4.getDistance(s4);
		double distanceSphericalToCartesian = s4.getDistance(c4);
		assertEquals(distanceCartesianToSpherical,distanceSphericalToCartesian,EPSILON);

		// testing if they are still the same after converting to the other format
		assertEquals(c4.asSphericCoordinate().getDistance(s4),distanceCartesianToSpherical,EPSILON);
		assertEquals(s4.asSphericCoordinate().getDistance(c4),distanceCartesianToSpherical,EPSILON);
	}



	@Test(expected = IllegalArgumentException.class)
	public void testIsEqual() {
		// testing if isEqual works for cartesian to cartesian 
		assertTrue(c1.isEqual(c1));
		assertTrue(c1.isEqual(c5));
		assertFalse(c1.isEqual(c2));

		//testing for cartesian to spheric
		assertTrue(c1.isEqual(s1));
		assertTrue(c2.isEqual(s2));
		assertFalse(c1.isEqual(s4));

		//testing for spheric to cartesian
		assertTrue(s1.isEqual(c1));
		assertTrue(s2.isEqual(c2));
		assertFalse(c3.isEqual(s4));

		//testing for spheric to spheric
		assertTrue(s1.isEqual(s1));
		assertTrue(s3.isEqual(s5));
		assertFalse(s1.isEqual(s4));

		// testing for invalid input
		c1.isEqual(null);
	}

	@Test
	public void testEquals() {
		// testing if isEqual works for cartesian to cartesian 
		assertTrue(c1.equals(c1));
		assertTrue(c1.equals(c5));
		assertFalse(c1.equals(c2));

		//testing for cartesian to spheric
		assertTrue(c1.equals(s1));
		assertTrue(c2.equals(s2));
		assertFalse(c1.equals(s4));

		//testing for spheric to cartesian
		assertTrue(s1.equals(c1));
		assertTrue(s2.equals(c2));
		assertFalse(c3.equals(s4));

		//testing for spheric to spheric
		assertTrue(s1.equals(s1));
		assertTrue(s3.equals(s5));
		assertFalse(s1.equals(s4));
		
		assertFalse(c1.equals(null));
	}


}
