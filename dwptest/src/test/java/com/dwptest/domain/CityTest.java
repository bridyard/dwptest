package com.dwptest.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CityTest {
	
	private City mCity;
	
	@Test
	public void testGetLatitudeLondon() {
		mCity = City.valueOf("LONDON");
		assertTrue(mCity.getLatitude().equals(new Float(51.5085300)));
	}
	
	@Test
	public void testGetLongitudeLondon() {
		mCity = City.valueOf("LONDON");
		assertTrue(mCity.getLongitude().equals(new Float(-0.1257400)));
	}
	
	@Test
	public void testGetMaximumLatitudeLondon() {
		mCity = City.valueOf("LONDON");
		assertTrue(mCity.getMaximumLatitude().equals(new Float(52.5085300)));
	}
	
	@Test
	public void testGetMinimumLatitudeLondon() {
		mCity = City.valueOf("LONDON");
		assertTrue(mCity.getMinimumLatitude().equals(new Float(50.5085300)));
	}
	
	@Test
	public void testGetMaximumLongitudeLondon() {
		mCity = City.valueOf("LONDON");
		assertTrue(mCity.getMaximumLongitude().equals(new Float(0.87426)));
	}
	
	@Test
	public void testGetMinimumLongitudeLondon() {
		mCity = City.valueOf("LONDON");
		assertTrue(mCity.getMinimumLongitude().equals(new Float(-1.1257400)));
	}

}
