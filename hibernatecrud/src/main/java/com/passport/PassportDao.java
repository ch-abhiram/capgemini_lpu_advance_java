package com.passport;

import jakarta.persistence.*;

import java.util.List;

public class PassportDao {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("mysql");

    // 🔹 CREATE
    public void addPassport(Passport passport) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(passport);
        et.commit();

        em.close();
    }

    // 🔹 FIND BY ID
    public Passport findByPassportNo(String passportNo) {
        EntityManager em = emf.createEntityManager();

        Passport passport = em.find(Passport.class, passportNo);

        em.close();
        return passport;
    }

    // 🔹 FIND ALL
    public List<Passport> findAll() {
        EntityManager em = emf.createEntityManager();

        List<Passport> list =
                em.createQuery("select p from Passport p", Passport.class)
                  .getResultList();

        em.close();
        return list;
    }

    // 🔹 UPDATE
    public void updateAddress(String passportNo, String newAddress) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Passport passport = em.find(Passport.class, passportNo);

        if (passport != null) {
            et.begin();
            passport.setAddress(newAddress);
            et.commit();
        } else {
            System.out.println("Passport not found");
        }

        em.close();
    }

    // 🔹 DELETE
    public void deletePassport(String passportNo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Passport passport = em.find(Passport.class, passportNo);

        if (passport != null) {
            et.begin();
            em.remove(passport);
            et.commit();
        } else {
            System.out.println("Passport not found");
        }

        em.close();
    }

    public void close() {
        emf.close();
    }
}
