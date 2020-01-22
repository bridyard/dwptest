package com.dwptest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DwpTestApiController {
	
	private static final String TARGET_URL = "https://bpdts-test-app.herokuapp.com/";

	@Autowired
	private RestTemplate mRestTemplate;

}
