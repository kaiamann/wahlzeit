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
