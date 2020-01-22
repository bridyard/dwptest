package com.dwptest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DwpTestApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(DwpTestApplicationTests.class);
	
	private static final String TARGET_URL = "https://bpdts-test-app.herokuapp.com/";

	@Autowired
	private RestTemplate mRestTemplate;

	@Test
	void contextLoads() {
		assertThat(mRestTemplate).isNotNull();
	}
	
	@Test
	public void testAccess() {
		ResponseEntity<Object> response = mRestTemplate.getForEntity(TARGET_URL + "/instructions", Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		log.info(response.getBody().toString());
	}

}
