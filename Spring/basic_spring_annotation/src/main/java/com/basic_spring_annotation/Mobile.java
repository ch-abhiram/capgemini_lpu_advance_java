package com.basic_spring_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Mobile {
	@Value("1234567890")
	private String number;

}
