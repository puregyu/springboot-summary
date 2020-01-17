package com.devyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//@ComponentScan
//@EnableAutoConfiguration
//@Configuration

@SpringBootApplication
public class SpringbootSummaryApplication {
	public static void main(String[] args) {
		
		// SpringApplication 커스터마이징(web 서버가 아닐때)
//		SpringApplication application = new SpringApplication();
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);
		
		SpringApplication.run(SpringbootSummaryApplication.class, args);
	}
}
