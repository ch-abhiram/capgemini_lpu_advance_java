package com.prac.dtoandmapper;

public class StudentMapper {
	
	public static Student createStudent(StudentDto dto) {
		Student s = new Student();
		s.setName(dto.getName());
		s.setGender(dto.getGender());
		s.setCollege(dto.getCollege());
		s.setMarks(dto.getMarks());
		
		return s;
		
	}

}
