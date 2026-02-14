package com.prac;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HospitalTest {

    private PatientDAO patientDAO = new PatientDAO();
    private DoctorDao doctorDAO = new DoctorDao();
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private HospitalService service = new HospitalService();

   
    @Test
    void testOneToOnePersist() {

        MedicalRecord record = new MedicalRecord();
        record.setId(101);
        record.setBloodGroup("O+");
        record.setAllergies("None");

        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Rahul");
        patient.setAge(25);
        patient.setContact(9999999999L);
        patient.setMedicalRecord(record);

        patientDAO.savePatient(patient);

        Patient saved = patientDAO.findPatient(1);

        assertNotNull(saved);
        assertEquals("Rahul", saved.getName());
        assertNotNull(saved.getMedicalRecord());
    }

    
    @Test
    void testOneToManyPersist() {

        Appointment a1 = new Appointment();
        a1.setId(201);
        a1.setVisitDate("2026-02-15");
        a1.setFee(500);

        Appointment a2 = new Appointment();
        a2.setId(202);
        a2.setVisitDate("2026-02-16");
        a2.setFee(700);

        Doctor doctor = new Doctor();
        doctor.setId(10);
        doctor.setName("Dr. Smith");
        doctor.setSpecialization("Cardiology");

        List<Appointment> list = Arrays.asList(a1, a2);
        doctor.setAppointments(list);

        doctorDAO.saveDoctor(doctor);

        Doctor savedDoctor = doctorDAO.findDoctor(10);

        assertNotNull(savedDoctor);
        assertEquals(2, savedDoctor.getAppointments().size());
    }

    
    @Test
    void testManyToOnePersist() {

        
        Patient patient = new Patient();
        patient.setId(1001);
        patient.setName("TestPatient");
        patient.setAge(30);
        patient.setContact(7777777777L);

        patientDAO.savePatient(patient);

        
        Appointment appointment = new Appointment();
        appointment.setId(302);
        appointment.setVisitDate("2026-02-20");
        appointment.setFee(800);
        appointment.setPatient(patient);

        appointmentDAO.saveAppointment(appointment);

        Appointment saved = appointmentDAO.findAppointment(301);

        assertNotNull(saved);
        assertNotNull(saved.getPatient());   
    }



    @Test
    void testDAOUpdate() {

        appointmentDAO.updateFee(301, 1200);

        Appointment updated = appointmentDAO.findAppointment(301);

        assertEquals(1200, updated.getFee());
    }

  
    @Test
    void testDAODelete() {

        patientDAO.deletePatient(1);

        Patient deleted = patientDAO.findPatient(1);

        assertNull(deleted);
    }

    
    @Test
    void testServiceWorkflow() {

        MedicalRecord record = new MedicalRecord();
        record.setId(500);
        record.setBloodGroup("A+");
        record.setAllergies("Dust");

        Patient patient = new Patient();
        patient.setId(50);
        patient.setName("Arjun");
        patient.setAge(28);
        patient.setContact(8888888888L);

        service.registerPatient(patient, record);

        Appointment ap = new Appointment();
        ap.setId(600);
        ap.setVisitDate("2026-02-25");
        ap.setFee(1000);

        appointmentDAO.saveAppointment(ap);

        service.assignAppointmentToPatient(600, 50);

        service.updateAppointmentFee(600, 1500);

        Appointment updated = appointmentDAO.findAppointment(600);

        assertEquals(1500, updated.getFee());

        boolean deleted = service.deletePatient(50);

        assertTrue(deleted);
    }
}
