package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarPhotoFactoryTest {
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	CarPhotoFactory instance;
	@Before
	public void setUp() {
		instance =  CarPhotoFactory.getInstance();
	}

	@Test
	public void testGetInstance() {
		assertNotEquals(instance,null);
	}

	@Test(expected = IllegalStateException.class)
	public void testDoubleInstantiation() {
		CarPhotoFactory.setInstance(new CarPhotoFactory());
	}

	@Test
	public void testCreatePhoto() {
		assertNotEquals(instance.createPhoto(),null);
	}
	
	@Test
	public void testCreatePhoto2() {
		PhotoId id = new PhotoId(1337);
		Photo expected = new CarPhoto(id);
		Photo got = instance.createPhoto(id);
		assertTrue(expected.getId().isEqual(got.getId()));
	}

}
