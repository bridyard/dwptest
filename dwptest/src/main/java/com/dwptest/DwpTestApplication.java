package com.dwptest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Class containing main method, from which application should be started.
 * @author Bev Ridyard
 *
 */
@SpringBootApplication
public class DwpTestApplication {

	private static final Logger log = LoggerFactory.getLogger(DwpTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DwpTestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
