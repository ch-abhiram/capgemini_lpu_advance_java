package com.capgemini.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
	@GetMapping("/home")
	public String getHi() {
		return "welcome";
	}
	@GetMapping("/register")
	public String createAccount() {
		return "register";
	}
//	@PostMapping("/create-account")
//	@ResponseBody
//	public String register(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String number = request.getParameter("number");
//		System.out.println(name+" "+email+" "+number);
//		return "User Registered";
//	}
	
//	@PostMapping("/create-account")
//	public String register(@ModelAttribute Users users) {
//		System.out.println(users.getName());
//		System.out.println(users.getEmail());
//		System.out.println(users.getNumber());
//		return "User Registered";
//	}
	@Autowired
	UserRepo jpa;
	@PostMapping("/create-account")
	public String register(@ModelAttribute Users users) {
		jpa.save(users);
		return "User Registered";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/logincheck")
	public String logincheck(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users user = jpa.findByEmailAndPassword(email, password);
		if(user!=null) {
			return "welcome";
			
		}else {
			return "redirect:/login";
		}
	}
	@GetMapping("/display")
	public ModelAndView sendData() {
		ModelAndView m = new ModelAndView();
		List<String> names = List.of("hello","huka","bye");
		m.addObject("msg",names);
		m.setViewName("display");
		return m;
	}

}
