package com.product;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql = "select p from Product p where  p.price>=?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, 130.0);
		
		List<Product> list = query.getResultList();
		list.forEach(i->System.out.println(i.getName()));
		
		
	}

}
