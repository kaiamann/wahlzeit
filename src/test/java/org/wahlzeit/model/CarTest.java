package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

	private static final double EPSILON = 1e-6;
	
	Car c;
	
	@Before
	public void setUp() throws Exception {
		c = new Car("Koenigsegg","Agera R");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetGetKilowatts() {
		assertEquals(0,c.getKilowatts(),EPSILON);
		
		double expected = 1014d;
		c.setKilowatts(expected);
		assertEquals(expected,c.getKilowatts(),EPSILON);
		
		c.setKilowatts(-1d);
	}
	
	@Test
	public void testSetGetManufacturer() {
		assertEquals("Koenigsegg",c.getManufacturer());
		
		String expected = "Porsche";
		c.setManufacturer(expected);
		assertEquals(expected,c.getManufacturer());
	}

}
