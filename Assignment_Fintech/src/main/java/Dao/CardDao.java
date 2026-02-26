package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.Entity.BankAccount;
import com.Entity.Card;
import com.Entity.Customer;
import com.Util.JpaUtil;

public class CardDao {
	
	EntityManager em = JpaUtil.getEntityManager();
	
	public void issueCard(Card card, Long accountId) {
		EntityTransaction et = em.getTransaction();
		
		BankAccount ba = em.find(BankAccount.class, accountId);
		
		et.begin();
		card.setBankAccount(ba);
		em.persist(card);
		et.commit();
	}
	
	public void assignCardToCustomer(Long cardId, Long customerId) {
		Card card = em.find(Card.class, cardId);
		Customer customer = em.find(Customer.class, customerId);
		
		if(card == null || customer == null) {
			System.out.println("no card or no customer found");
			return;
		}
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		customer.getCards().add(card);
		em.merge(card);
		et.commit();
		
	}
	
	public Card findById(Long id) {
		return em.find(Card.class, id);
	}
	
	public List<Card> findAll() {
		return em.createQuery("select c from Card c", Card.class).getResultList();
	}
	
	public void deactivateCard(Long cardId) {
		Card c = em.find(Card.class, cardId);
		
		if(c == null) {
			System.out.println("card not found");
			return;
		}
		EntityTransaction et = em.getTransaction();
		et.begin();
		c.setActive(false);
		et.commit();
		
	}
	
}