package com.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.Service.AppointmentService;
import com.Service.DepartmentService;
import com.Service.DoctorService;
import com.Service.PatientService;
import com.Utility.Appointment;
import com.Utility.Department;
import com.Utility.Doctor;
import com.Utility.Patient;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== HOSPITAL ERP SYSTEM STARTED =====");

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        DepartmentService departmentService = new DepartmentService();
        AppointmentService appointmentService = new AppointmentService();

     
        Long cardioId = departmentService.createDepartment(
                "Cardiology", "Block A", "Dr. Rao");

        Long neuroId = departmentService.createDepartment(
                "Neurology", "Block B", "Dr. Mehta");

        System.out.println("Departments created.");

      
        Long doc1Id = doctorService.createDoctor(
                "Dr. Smith", "Cardiologist", "LIC123");

        Long doc2Id = doctorService.createDoctor(
                "Dr. John", "Neurologist", "LIC456");

        System.out.println("Doctors created.");

        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Department cardio = em.find(Department.class, cardioId);
        Department neuro = em.find(Department.class, neuroId);

        Doctor doctor1 = em.find(Doctor.class, doc1Id);
        Doctor doctor2 = em.find(Doctor.class, doc2Id);

        cardio.addDoctor(doctor1);
        neuro.addDoctor(doctor2);

        tx.commit();
        em.close();

        System.out.println("Doctors assigned to Departments.");

        
        Long pat1Id = patientService.createPatient(
                "Rahul",
                LocalDate.of(2000, 5, 10),
                "O+",
                "9999999999",
                "Flu",
                "Rest 3 days");

        Long pat2Id = patientService.createPatient(
                "Anita",
                LocalDate.of(1998, 3, 15),
                "A+",
                "8888888888",
                "Migraine",
                "Avoid stress");

        System.out.println("Patients created.");

        
        em = emf.createEntityManager();
        tx = em.getTransaction();

        tx.begin();

        Doctor d = em.find(Doctor.class, doc1Id);
        Patient p1 = em.find(Patient.class, pat1Id);
        Patient p2 = em.find(Patient.class, pat2Id);

        d.addPatient(p1);
        d.addPatient(p2);

        tx.commit();
        em.close();

        System.out.println("Patients assigned to Doctor.");

        
        doctorService.addAppointment(
                doc1Id,
                LocalDateTime.now(),
                "SCHEDULED",
                "Regular Checkup");

        System.out.println("Appointment added.");

        
        em = emf.createEntityManager();

        Appointment appointment = em.createQuery(
                "SELECT a FROM Appointment a", Appointment.class)
                .setMaxResults(1)
                .getSingleResult();

        em.close();

        appointmentService.addPrescription(
                appointment.getId(),
                "Paracetamol",
                "500mg twice daily");

        System.out.println("Prescription added.");

        
        em = emf.createEntityManager();

        Doctor fetchedDoctor = em.find(Doctor.class, doc1Id);

        System.out.println("\n----- Doctor Details -----");
        System.out.println("Name: " + fetchedDoctor.getName());
        System.out.println("Department: " +
                fetchedDoctor.getDepartment().getName());

        System.out.println("\nPatients under this Doctor:");
        for (Patient p : fetchedDoctor.getPatients()) {
            System.out.println(" - " + p.getName());
        }

        System.out.println("\nAppointments:");
        for (Appointment a : fetchedDoctor.getAppointments()) {

            System.out.println("Status: " + a.getStatus());

            if (a.getPrescription() != null) {
                System.out.println("Prescription: "
                        + a.getPrescription().getMedicines());
            }
        }

        em.close();
        emf.close();

        System.out.println("\n===== SYSTEM FINISHED SUCCESSFULLY =====");
    }
}
