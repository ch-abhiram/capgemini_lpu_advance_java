package com.docker_database.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.docker_database.Entity.Student;
import com.docker_database.Repo.Studentrepo;

@RestController
public class StudentController {
	@Autowired
	private Studentrepo jpa;
	
	
	@PostMapping("/create")
	public Student create(@RequestBody Student stu) {
	    return jpa.save(stu);
	}
	
	@GetMapping("/all")
    public List<Student> getAllStudents() {
        return jpa.findAll();
    }

    // DISPLAY STUDENT BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return jpa.findById(id).orElse(null);
    }
	

}
