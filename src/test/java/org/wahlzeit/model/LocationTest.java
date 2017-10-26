package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	Coordinate c1 ,c2, c3, c4, c5;
	
	Location a;
	Location b;
	Location c;

	@Before
	public void setUp() throws Exception {
		c1 = new Coordinate(0,0,0);
		c2 = new Coordinate(1,0,0);
		c3 = new Coordinate(0,2,0);
		c4 = new Coordinate(4,5,6);
		c5 = new Coordinate(0,0,0);
		
		a = new Location();
		b = new Location(c2);
		c = new Location(1,1,1);
	}

	@Test
	public void testGetDistance() {
		double distance = c1.getDistance(c2);
		System.out.println("Got "+ distance + " Expected: 1.0");
		assert(distance == 1);
		
		distance = c1.getDistance(c3);
		System.out.println("Got "+ distance + " Expected: 2.0");
		assert(distance == 2);
		
		distance = c1.getDistance(c4);
		System.out.println("Got "+ distance + " Expected: "+Math.sqrt(16+25+36));
		assert(distance == Math.sqrt(16+25+36));
	}
	
	@Test
	public void testIsEqual() {
		assert(c1.isEqual(c1));
		assert(c1.isEqual(c5));
	}
	
	@Test
	public void testEquals() {
		assert(c1.equals(c1));
		assert(c1.equals(c5));
	}
	
	@Test
	public void testGetters() {
		assert(c4.getX() == 4);
		assert(c4.getY() == 5);
		assert(c4.getZ() == 6);
	}

}
