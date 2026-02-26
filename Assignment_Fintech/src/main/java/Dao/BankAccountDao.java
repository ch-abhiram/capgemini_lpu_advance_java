package Dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.Entity.BankAccount;
import com.Entity.Customer;
import com.Util.JpaUtil;

public class BankAccountDao {
	
	EntityManager em = JpaUtil.getEntityManager();
	
	public void save(BankAccount ba) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(ba);
		et.commit();
	}
	
	public BankAccount findById(Long id) {
		return em.find(BankAccount.class, id);
	}
	
	public BankAccount findByAccountNumber(String accountNumber) {
		String jpql = "select b from BankAccount b where b.accountNumber=:ac";
		Query query = em.createQuery(jpql, BankAccount.class);
		query.setParameter("ac", accountNumber);
		return (BankAccount) query.getSingleResult();	
	}
	
	public void linkToCustomer(Long accountId, Long customerId) {
		BankAccount account = em.find(BankAccount.class, accountId);
		Customer customer = em.find(Customer.class, customerId);
		
		if(account==null || customer==null){
			   System.out.println("Invalid ids");
			   return;
		}
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		account.setCustomer(customer);
		customer.setBankAccount(account);
		
		em.merge(customer);
		em.merge(account);
		
		et.commit();
		
	}
	
	public void updateBalance(Long accountId, BigDecimal newBalance) {
		BankAccount account = em.find(BankAccount.class, accountId);
		
		EntityTransaction et = em.getTransaction();
		et.begin();

		
		account.setBalance(newBalance);
		et.commit();
	}
	
	public List<BankAccount> findAll(){
		String jpql = "select b from BankAccount b";
		Query query = em.createQuery(jpql, BankAccount.class);
		return query.getResultList();
	}
	
}
