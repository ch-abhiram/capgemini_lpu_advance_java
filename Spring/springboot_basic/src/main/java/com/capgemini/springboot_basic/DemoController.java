package com.capgemini.springboot_basic;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

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
	
	@Autowired
	PersonJpaRepository jpa;
	@PostMapping("/per")
	public String createP(@RequestBody Person p) {
		Person P= jpa.save(p);
		System.out.println(p);
		return p.toString();
	}
	@GetMapping("/find")
	public String getById(@RequestParam int id) {
		Optional<Person> p = jpa.findById(id);
		return p.isPresent()?p.get().toString():"Data not Exsist";
		
	}
	@DeleteMapping("/delete")
	public String deleteById(@RequestParam int id) {
		if(jpa.existsById(id)){
			jpa.deleteById(id);
			return "deleted";
			
		}else {
			return "Data doesn't exsist";
		}
	}
	@PutMapping("/update/{id}")
	public String updatePerson(@PathVariable int id,@RequestBody Person p) {
		Optional<Person> object = jpa.findById(id);
		if(object.isPresent()) {
			Person per = object.get();
			per.setId(p.getId());
			per.setName(p.getName());
			jpa.save(per);
			return "updated";
		}else {
			return "does not exsist";
		}
		
	}
	@PatchMapping("updateName/{id}")
	public String updateName(@PathVariable int id,@RequestBody Person p) {
		Optional<Person> obj = jpa.findById(id);
		if(obj.isPresent()) {
			Person per = obj.get();
			
			if(p.getName()!=null) {
				per.setName(p.getName());
			}
			jpa.save(per);
			return "updated name";
		}else {
			return "data not exsist";
		}
	}
	@GetMapping("/findname/{name}")
	public Person gePersonByName(@PathVariable String name) {
		return jpa.getByName(name);
	}
	
	
}
