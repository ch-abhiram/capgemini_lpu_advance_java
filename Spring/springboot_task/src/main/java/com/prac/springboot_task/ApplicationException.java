package com.prac.springboot_task;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationException {
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "Exception handled";
	}
	
	
	 

}
