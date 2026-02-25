package com.Service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Utility.MedicalRecord;
import com.Utility.Patient;

public class PatientService {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public Long createPatient(String name, LocalDate dob,
                              String bloodGroup, String phone,
                              String diagnosis, String notes) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            MedicalRecord record = new MedicalRecord(
                    LocalDate.now(),
                    diagnosis,
                    notes
            );

            Patient patient = new Patient(name, dob, bloodGroup, phone);
            patient.setMedicalRecord(record);

            em.persist(patient);

            tx.commit();
            return patient.getId();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Patient getPatient(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Patient.class, id);
        } finally {
            em.close();
        }
    }

    public void deletePatient(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Patient patient = em.find(Patient.class, id);
            em.remove(patient);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
