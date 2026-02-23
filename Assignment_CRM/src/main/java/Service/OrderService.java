package Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.entity.Customer;
import com.entity.Order;
import com.entity.Product;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    
    public void placeOrder(Long customerId, List<Long> productIds) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);
            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }

            List<Product> products = new ArrayList<>();
            double total = 0;

            for (Long pid : productIds) {
                Product p = em.find(Product.class, pid);
                if (p != null) {
                    products.add(p);
                    total += p.getPrice();
                }
            }

            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            order.setOrderDate(LocalDate.now());
            order.setTotalAmount(total);

            em.persist(order);

            tx.commit();
            System.out.println("Order Placed Successfully! Total = " + total);
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}
