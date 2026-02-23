package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.entity.Order;
import com.entity.SupportTicket;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    
    public void raiseTicket(Long orderId, String issueDescription) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Order order = em.find(Order.class, orderId);
            if (order == null) {
                System.out.println("Order not found!");
                return;
            }

            SupportTicket ticket = new SupportTicket();
            ticket.setOrder(order);
            ticket.setIssueDescription(issueDescription);

            em.persist(ticket);

            tx.commit();
            System.out.println("Support Ticket Raised Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}