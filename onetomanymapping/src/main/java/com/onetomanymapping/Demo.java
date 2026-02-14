package com.onetomanymapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		College c = em.find(College.class, 1);
		
		Student s1 = new Student();
		s1.setStu_Id(106);
		s1.setName("ramulu");
		s1.setBranch("CSE");
		
		List<Student> list = new ArrayList<Student>();
		list = c.getStu();
		list.add(s1);
		c.setStu(list);
		
		et.begin();
		em.persist(s1);
		et.commit();
		em.close();
	}

}
