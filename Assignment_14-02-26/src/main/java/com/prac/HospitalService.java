package com.prac;

import java.util.List;

public class HospitalService {

    private PatientDAO patientDAO = new PatientDAO();
    private DoctorDao doctorDAO = new DoctorDao();
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

   
    public void registerPatient(Patient patient, MedicalRecord record) {

        patient.setMedicalRecord(record);  
        patientDAO.savePatient(patient);
    }


    public void addAppointmentsToDoctor(int doctorId, List<Appointment> appointments) {

        Doctor doctor = doctorDAO.findDoctor(doctorId);

        if (doctor != null) {
            doctor.setAppointments(appointments);  
            doctorDAO.saveDoctor(doctor);
        }
    }

    
    public void assignAppointmentToPatient(int appointmentId, int patientId) {

        Patient patient = patientDAO.findPatient(patientId);
        Appointment appointment = appointmentDAO.findAppointment(appointmentId);

        if (patient != null && appointment != null) {
            appointment.setPatient(patient);  // ManyToOne mapping
            appointmentDAO.saveAppointment(appointment);
        }
    }

    
    public void updateAppointmentFee(int appointmentId, double newFee) {
        appointmentDAO.updateFee(appointmentId, newFee);
    }

    
    public Doctor fetchDoctorWithAppointments(int doctorId) {
        return doctorDAO.findDoctor(doctorId);
    }

    
    public boolean deletePatient(int patientId) {

        patientDAO.deletePatient(patientId);

        Patient deleted = patientDAO.findPatient(patientId);

        if (deleted == null) {
            System.out.println("Patient successfully deleted.");
            return true;
        } else {
            System.out.println("Deletion failed.");
            return false;
        }
    }
}
