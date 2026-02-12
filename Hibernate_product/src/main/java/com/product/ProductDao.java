package com.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();

    public String insertProduct(Product p) {

        if (p == null) {
            return "Invalid Argument";
        }

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();

        return "Data Inserted";
    }

    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
