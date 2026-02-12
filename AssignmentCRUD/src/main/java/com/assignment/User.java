package com.assignment;

public class User {
	public static void main(String[] args) {
		StudentDao obj = new StudentDao();
		
		Student stu = new Student();
		stu.setId(102);
		stu.setName("abhiram");
		stu.setEmail("abhiram@gmail.com");
		stu.setMarks(92.9);
		
		obj.saveStudent(stu);
//		Student s = obj.findStudentById(101);
//		System.out.println(s);
	}

}
