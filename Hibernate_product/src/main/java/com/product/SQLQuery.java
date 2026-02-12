package com.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SQLQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		String sql = "update product set price=?1 where price=?2";
		et.begin();
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, 500.0);
		query.setParameter(2, 100.0);
		query.executeUpdate();
		et.commit();
		em.close();
		emf.close();
		
	}

}
