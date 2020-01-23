package com.dwptest.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dwptest.domain.City;
import com.dwptest.domain.User;

/**
 * Class acting as REST client to provide access to DWP API.
 * @author Bev Ridyard
 *
 */
@Component
public class DwpRestClient {

	private static final Logger log = LoggerFactory.getLogger(DwpRestClient.class);
	
	private static final String TARGET_URL = "https://bpdts-test-app.herokuapp.com";

	@Autowired
	private RestTemplate mRestTemplate;
	
	List<User> getResidentUsersForCity(String aCity) {		
		log.debug("Getting residents of city [" + aCity + "]");
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("city", aCity);
		User[] residentsArray = mRestTemplate.getForObject(TARGET_URL + "/city/" + aCity + "/users", User[].class, parameters);
		List<User> residents = Arrays.asList(residentsArray);
		
		log.debug("Found " + residents.size() + " residents");
		return residents;
	}
	
	List<User> getUsersLocatedInCity(String aCity) {
		log.debug("Getting users located in city [" + aCity + "]");

		log.debug("Getting all users");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("city", aCity);
		User[] allUsersArray = mRestTemplate.getForObject(TARGET_URL + "/users", User[].class, parameters);
		List<User> allUsers = Arrays.asList(allUsersArray);
		log.debug("Found " + allUsers.size() + " users in total");
		
		log.debug("Filtering out users located in " + aCity);
		List<User> cityUsers = filterUsersByCity(aCity, allUsers);		
		log.debug("Found " + cityUsers.size() + " users in " + aCity);
		
		return cityUsers;
	}
	
	private List<User> filterUsersByCity(String aCity, List<User> aUsersToFilter) {
		if (aUsersToFilter == null || aUsersToFilter.isEmpty()) {
			return new ArrayList<User>();
		}
		List<User> cityUsers = new ArrayList<User> ();
		try {
		  City city = City.valueOf(aCity.toUpperCase());
			for (User user : aUsersToFilter) {
				if (user.getLatitude() < city.getMaximumLatitude() 
					&& user.getLatitude() > city.getMinimumLatitude() 
					&& user.getLongitude() < city.getMaximumLongitude() 
					&& user.getLongitude() > city.getMinimumLongitude()) {
					cityUsers.add(user);
				}
			}
		}
		catch (IllegalArgumentException iae) {
			log.error("City [" + aCity + "] does not exist");
		}
		return cityUsers;
	}

}
