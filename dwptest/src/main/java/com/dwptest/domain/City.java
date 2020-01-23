package com.dwptest.domain;

/**
 * Class to represent a city and provide:
 * - latitude, longitude, 
 * - maximum latitude, minimum latitude, maximum longitude, minimum longitude to provide a 50 mile radius around the city.
 * A 50 mile radius is assumed to be 1 degree in either direction for both latitude and longitude.
 * @author Bev Ridyard
 *
 */
public enum City {
	
	LONDON(51.5085300F, -0.1257400F);
	
	private Float mLatitude;
	private Float mLongitude;
	
	City(Float aLatitude, Float aLongitude) {
		mLatitude = aLatitude;
		mLongitude = aLongitude;
	}
	
	public Float getLatitude() {
		return mLatitude;
	}
	
	public Float getLongitude() {
		return mLongitude;
	}
	
	public Float getMaximumLatitude() {
		return mLatitude + 1;
	}
	
	public Float getMinimumLatitude() {
		return mLatitude - 1;
	}
	
	public Float getMaximumLongitude() {
		return mLongitude + 1;
	}
	
	public Float getMinimumLongitude() {
		return mLongitude - 1;
	}

}
