package Service;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.entity.Address;
import com.entity.Customer;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    
    public void registerCustomer(String name, String email, String phone) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);

            em.persist(customer);

            tx.commit();
            System.out.println("Customer Registered Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    
    public void addAddressToCustomer(Long customerId, Address address) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);
            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }

            customer.setAddress(address);
            em.merge(customer);

            tx.commit();
            System.out.println("Address Added Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}
