package com.dwptest.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dwptest.domain.User;

@SpringBootTest
public class DwpTestApiControllerTest {
	
	@Autowired
	private DwpTestApiController mController;
	
	@Test
	public void testApiSuccess() {
		List<User> response = mController.getUsersResidentOrLocatedWithinCity("London");
		assertTrue(response.size() == 9);
	}

	@Test
	public void testCombineAndRemoveDuplicatesNoEmptyLists() {
		User firstUser = new User(1, "Donald", "Duck", "donald.duck@disney.com", "192.0.0.1", 50.012345F, 0.012345F);
		User secondUser = new User(2, "Mickey", "Mouse", "mickey.mouse@disney.com", "192.0.0.1", 50.012345F, 0.012345F);
		User thirdUser = new User(3, "Minnie", "Mouse", "minnie.mouse@disney.com", "192.0.0.1", 50.012345F, 0.012345F);
		List<User> firstList = new ArrayList<User>();
		firstList.add(firstUser);
		firstList.add(secondUser);
		List<User> secondList = new ArrayList<User>();
		secondList.add(secondUser);
		secondList.add(thirdUser);		
		List<User> expectedList = new ArrayList<User>();
		expectedList.add(firstUser);
		expectedList.add(secondUser);
		expectedList.add(thirdUser);
		
		List<User> result = mController.combineAndRemoveDuplicates(firstList, secondList);
		assertTrue(result.size() == 3);
		assertTrue(result.equals(expectedList));
	}

}
