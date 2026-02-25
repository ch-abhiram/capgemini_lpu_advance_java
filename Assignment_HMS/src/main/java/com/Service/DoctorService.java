package com.Service;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Utility.Appointment;
import com.Utility.Doctor;

public class DoctorService {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public Long createDoctor(String name,
                             String specialization,
                             String licenseNo) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Doctor doctor = new Doctor(name, specialization, licenseNo);
            em.persist(doctor);

            tx.commit();
            return doctor.getId();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void addAppointment(Long doctorId,
                               LocalDateTime date,
                               String status,
                               String reason) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Doctor doctor = em.find(Doctor.class, doctorId);
            Appointment appointment =
                    new Appointment(date, status, reason);

            doctor.getAppointments().add(appointment);

            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}