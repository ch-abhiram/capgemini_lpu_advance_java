package com.practice;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em  = emf.createEntityManager();
	
	public void insertUsers() {
		EntityTransaction et = em.getTransaction();
		User user = new User();
		user.setId(1);
		user.setName("hello");
		user.setBalance(120000.0);
		et.begin();
		em.persist(user);
		et.commit();
	}
	
	public User findById(int id) {
		return em.find(User.class, id);
	}

}
