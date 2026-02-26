package com.prac.springboot_task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerJpa jpa;
	@PostMapping("/customer")
	public String setCustomer(@RequestBody Customer c) {
		Customer obj = jpa.save(c);
		return obj.toString();
	}
	@GetMapping("/getcustomer")
	public String getCustomer(@RequestParam int id) {
		
		if(jpa.existsById(id)) {
			return jpa.findById(id).get().toString();
		}else {
			throw new DataNotExist();		
			}
	}
	@PutMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable int id,@RequestBody Customer c) {
		Optional<Customer> obj = jpa.findById(id);
		
		if(obj.isPresent()) {
			Customer cus = obj.get();
			
			cus.setName(c.getName());
			cus.setEmail(c.getEmail());
			cus.setGender(c.getGender());
			cus.setDob(c.getDob());
			cus.setPhone(c.getPhone());
			
			jpa.save(cus);
			return "updated";
		}else {
			return "not found";
		}
	}
	@DeleteMapping("/delete/{name}")
	public String deleteByName(@PathVariable String name) {
		int count = jpa.deleteByName(name);
		if(count == 0) {
			return "data not found";
		}else {
			return count+"data deleted";
		}
	}
	
	@ExceptionHandler(DataNotExist.class)
	public String handleException() {
		return "Exception handled";
	}
	 
	
	

}
