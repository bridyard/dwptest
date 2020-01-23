package com.dwptest.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dwptest.domain.City;
import com.dwptest.domain.User;

@SpringBootTest
public class DwpRestClientTest {

	private static final Logger log = LoggerFactory.getLogger(DwpRestClientTest.class);
	
	@Autowired
	private DwpRestClient mRestClient;
	
	@Test
	public void testGetResidentUsersForCitySuccess() {
		String cityName = "London";
		List<User> response = mRestClient.getResidentUsersForCity(cityName);
		assertTrue(response.size() == 6);
		for (User user : response) {
			log.debug("User: " + user);
		}
	}
	
	@Test
	public void testGetResidentUsersForNonExistentCity() {
		String cityName = "Manchester";
		List<User> response = mRestClient.getResidentUsersForCity(cityName);
		assertNotNull(response);
		assertTrue(response.isEmpty());
	}
	
	@Test
	public void testGetUsersLocatedInLondonSuccess() {
		String cityName = "London";
		List<User> response = mRestClient.getUsersLocatedInCity(cityName);
		City london = City.valueOf(cityName.toUpperCase());
		for (User user : response) {
			assertTrue(user.getLatitude() < london.getMaximumLatitude()
					&& user.getLatitude() > london.getMinimumLatitude()
					&& user.getLongitude() < london.getMaximumLongitude()
					&& user.getLongitude() > london.getMinimumLongitude());
			log.debug("User: " + user);
		}
	}
	
	@Test
	public void testGetUsersLocatedInNonExistentCity() {
		String cityName = "Manchester";
		List<User> response = mRestClient.getUsersLocatedInCity(cityName);
		assertNotNull(response);
		assertTrue(response.isEmpty());
	}

}
