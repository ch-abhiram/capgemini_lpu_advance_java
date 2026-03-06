package com.prac.dtoandmapper;

public class StudentService {
	
	Studentrepo jpa;

	public StudentService(Studentrepo jpa) {
		super();
		this.jpa = jpa;
	}
	
	public Student addStudent(StudentDto dto) {
		return jpa.save(dto);
	}
	

}
