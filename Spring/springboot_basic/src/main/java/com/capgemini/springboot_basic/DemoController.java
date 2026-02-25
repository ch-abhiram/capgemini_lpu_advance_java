package com.capgemini.springboot_basic;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class DemoController {
	
//	@GetMapping("/msg")
	@PostMapping("/msg")
//	@ResponseBody
	public List<String> hello() {
		return List.of("hello","past","huha","haha");
	}
	@PostMapping("/add")
	public String createCricketer(@RequestBody Cricketer c) {
		System.out.println(c);
		return c.toString();
	}
	@PostMapping("/car")
	public String createCar(@RequestBody Car c) {
		System.out.println(c);
		return c.toString();
	}
	
	@PostMapping("per")
	public String createP(@RequestBody Person p) {
		System.out.println(p);
		return p.toString();
	}
}
