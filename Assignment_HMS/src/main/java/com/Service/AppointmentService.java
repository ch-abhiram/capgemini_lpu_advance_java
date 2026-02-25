package com.Service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Utility.Appointment;
import com.Utility.Prescription;

public class AppointmentService {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void addPrescription(Long appointmentId,
                                String medicines,
                                String dosage) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Appointment appointment =
                    em.find(Appointment.class, appointmentId);

            Prescription prescription =
                    new Prescription(
                            medicines,
                            dosage,
                            LocalDate.now(),
                            true
                    );

            appointment.setPrescription(prescription);

            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
