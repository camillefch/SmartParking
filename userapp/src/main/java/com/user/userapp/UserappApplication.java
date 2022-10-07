package com.user.userapp;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserappApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserappApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
