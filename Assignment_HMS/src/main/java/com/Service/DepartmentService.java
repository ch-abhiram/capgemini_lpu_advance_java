package com.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Utility.Department;

public class DepartmentService {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public Long createDepartment(String name,
                                 String location,
                                 String headDoctorName) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Department department =
                    new Department(name, location, headDoctorName);

            em.persist(department);

            tx.commit();
            return department.getId();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
