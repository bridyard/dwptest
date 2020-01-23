package com.dwptest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwptest.DwpTestApplication;
import com.dwptest.domain.User;

/**
 * Controller providing public API.
 * @author Bev Ridyard
 */
@RestController
public class DwpTestApiController {

	private static final Logger log = LoggerFactory.getLogger(DwpTestApplication.class);

	@Autowired
	private DwpRestClient mRestClient;
	
	@GetMapping("/city/{city}/users")
	public List<User> getUsersResidentOrLocatedWithinCity(String aCity) {
		log.info("Received request to retrieve residents and users located in " + aCity);
		
		List<User> residentUsers = mRestClient.getResidentUsersForCity(aCity);		
		
		List<User> nonResidentUsers = mRestClient.getUsersLocatedInCity(aCity);
		
		//Remove any duplication between the two lists		
		List<User> allUsers = combineAndRemoveDuplicates(residentUsers, nonResidentUsers);
		
		log.info("Returning " + allUsers.size() + " users for " + aCity);
		return allUsers;		
	}
	
	List<User> combineAndRemoveDuplicates(List<User> aFirstList, List<User> aSecondList) {
		List<User> combinedList = new ArrayList<User>();
		combinedList.addAll(aFirstList);
		combinedList.addAll(aSecondList);
		
		List<User> newList = new ArrayList<User>();
		for (User combinedListUser : combinedList) {
			if (!newList.contains(combinedListUser)) {
				newList.add(combinedListUser);
			}
		}
		
		return newList;
	}

}
