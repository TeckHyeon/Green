package com.bitc.kdh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class GametalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GametalkApplication.class, args);
	}

}
