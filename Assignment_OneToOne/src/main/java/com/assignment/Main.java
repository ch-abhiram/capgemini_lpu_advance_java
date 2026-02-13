package com.assignment;

public class Main {
	public static void main(String[] args) {
		AadharCardDao cardDao = new AadharCardDao();
		HostelRoomDao roomDao = new HostelRoomDao();
		StudentDao stu = new StudentDao();
		
		AadharCard card = new AadharCard();
		card.setId(1);
		card.setAadharNumber("1234-5678");
		card.setAddress("HYD");
		card.setIssueDate("2008");
		
		cardDao.insertData(card);
		
		
		HostelRoom room = new HostelRoom();
		room.setId(101);
		room.setRoomNumber(12);
		room.setBlockName("A");
		room.setFloorNumber(1);
		roomDao.insertData(room);
		
		Student student = new Student();
        student.setId(1);
        student.setName("Abhiram");
        student.setEmail("abhi@gmail.com");
        student.setBranch("CSE");
        
        student.setAadharCard(card);
        student.setHostelRoom(room);
        
       stu.insertData(student);
       
        Student res = stu.findData(1);
        System.out.println(res);
        
        stu.delete(1);
        
	}

}
