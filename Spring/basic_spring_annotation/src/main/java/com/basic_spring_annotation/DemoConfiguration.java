package com.basic_spring_annotation;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")
public class DemoConfiguration {
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
}
