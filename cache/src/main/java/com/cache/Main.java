package com.cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    static EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("postgres");

    public static void main(String[] args) {
        read();
//    	insert();
    }

    public static void insert() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Product p = new Product();
        p.setName("arya");

        et.begin();
        em.persist(p);
        et.commit();

        em.close();
    }

    public static void read() {
        EntityManager em = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();

        System.out.println("--------------first level cache--------------");

        em.find(Product.class, 1);  
        em2.find(Product.class, 1);  

        em.close();
    }
}