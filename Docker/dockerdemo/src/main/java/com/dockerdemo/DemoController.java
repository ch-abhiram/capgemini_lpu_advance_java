package com.dockerdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class DemoController {
	
	@GetMapping("/hello")
	public String view() {
		return "Hello";
	}
}
