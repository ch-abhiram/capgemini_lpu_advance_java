package com.onetomanymapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DemoDel {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student stu = em.find(Student.class, 101);
		if(stu!=null) {
			String sql = "delete from college_stu where stu_stu_id=?1";
			String Stusql = "delete from stu where stu_id=?1";
			
			Query query = em.createNativeQuery(sql);
			Query stuQuery = em.createNativeQuery(Stusql);
			query.setParameter(1,101);
			stuQuery.setParameter(1, 101);
			et.begin();
			query.executeUpdate();
			stuQuery.executeUpdate();
			
			et.commit();
		}
		
		
	}


}
