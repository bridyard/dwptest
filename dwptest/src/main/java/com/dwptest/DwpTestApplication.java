package com.dwptest;

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

	public static void main(String[] aArgs) {
		SpringApplication.run(DwpTestApplication.class, aArgs);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder aBuilder) {
		return aBuilder.build();
	}

}
