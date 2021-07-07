package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ConfigurationProperties(prefix ="goal")
public class FinacialProj1Application {
	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(FinacialProj1Application.class, args); }
	 */

}
