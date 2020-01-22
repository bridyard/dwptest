package com.dwptest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class to contain individual user returned from REST service.
 * @author Bev Ridyard
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	private int mId;
	private String mFirstName;
	private String mLastName;
	private String mEmail;
	private String mIpAddress;
	private Float mLatitude;
	private Float mLongitude;
	
	public int getId() {
		return mId;
	}
	
	public void setId(int aId) {
		mId = aId;
	}
	
	public String getFirstName() {
		return mFirstName;
	}
	
	public void setFirstName(String aFirstName) {
		mFirstName = aFirstName;
	}
	
	public String getLastName() {
		return mLastName;
	}
	
	public void setLastName(String aLastName) {
		mLastName = aLastName;
	}
	
	public String getEmail() {
		return mEmail;
	}
	
	public void setEmail(String aEmail) {
		mEmail = aEmail;
	}
	
	public String getIpAddress() {
		return mIpAddress;
	}
	
	public void setIpAddress(String aIpAddress) {
		mIpAddress = aIpAddress;
	}
	
	public Float getLatitude() {
		return mLatitude;
	}
	
	public void setLatitude(Float aLatitude) {
		mLatitude = aLatitude;
	}
	
	public Float getLongitude() {
		return mLongitude;
	}
	
	public void setLongitude(Float aLongitude) {
		mLongitude = aLongitude;
	}

}
