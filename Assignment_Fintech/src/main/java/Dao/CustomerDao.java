package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.Entity.Customer;
import com.Util.JpaUtil;

public class CustomerDao {

	
	EntityManager em = JpaUtil.getEntityManager();
	
	public void save(Customer c) {
		EntityTransaction et = em.getTransaction();
		
		if(c.getCards() == null){
	        c.setCards(new ArrayList<>());
	    }
		
		et.begin();
		em.persist(c);
		et.commit();
	}
	
	public Customer findById(Long id) {
		return em.find(Customer.class, id);
	}
	
	public List<Customer> findAll(){
		
		String jpql = "select c from Customer c";
		Query query = em.createQuery(jpql);
		
		List<Customer> list = query.getResultList();
		return list;
	}
	
	public Customer findByEmail(String email) {
        return em.createQuery(
                "SELECT c FROM Customer c WHERE c.email = :email",
                Customer.class)
                .setParameter("email", email)
                .getSingleResult();
	}
	
	public void update(Customer c) {
		
		EntityTransaction et = em.getTransaction();
		
		Customer customer = findById(c.getCustomerId());
		
		if(customer != null) {
			et.begin();
			em.merge(c);
			et.commit();
		}else {
			System.out.println("customer not found");
		}
		
	}
	
	public void delete(Long id) {
		EntityTransaction et = em.getTransaction();
		
		Customer c = findById(id);
		if(c != null) {
			et.begin();
			em.remove(c);
			et.commit();
		}
		
	}
	
	
}
