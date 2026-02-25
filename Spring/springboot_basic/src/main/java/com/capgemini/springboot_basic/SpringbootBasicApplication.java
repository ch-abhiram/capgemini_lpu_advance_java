package com.capgemini.springboot_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

//@Configuration
//@ComponentScan(basePackages = "com")
//@EnableAutoConfiguration
public class SpringbootBasicApplication {

	public static void main(String[] args) {
		  ApplicationContext ioc = SpringApplication.run(SpringbootBasicApplication.class, args);
		   Doctor doc = ioc.getBean(Doctor.class);
		   doc.display();
	}

}
