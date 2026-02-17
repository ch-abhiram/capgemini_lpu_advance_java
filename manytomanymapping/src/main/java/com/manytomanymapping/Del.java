package com.manytomanymapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Del {
	public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        String sql = "delete from studentt_subject where subject_id=?1";
        String sqlTable = "delete from subject where id=?1";

        Query query = em.createNativeQuery(sql);
        Query queryTable = em.createNativeQuery(sqlTable);

        query.setParameter(1, 2);
        queryTable.setParameter(1, 2);

        et.begin();

        query.executeUpdate();       
        queryTable.executeUpdate();  

        et.commit();

        em.close();
        emf.close();

        System.out.println("Deleted Successfully");
    }
}
