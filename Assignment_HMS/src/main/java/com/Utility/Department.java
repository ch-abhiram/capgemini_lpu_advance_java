package com.Utility;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String headDoctorName;

    @OneToMany(mappedBy = "department",
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    private List<Doctor> doctors = new ArrayList<>();

    public Department() {}

    public Department(String name, String location, String headDoctorName) {
        this.name = name;
        this.location = location;
        this.headDoctorName = headDoctorName;
    }

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHeadDoctorName() {
		return headDoctorName;
	}

	public void setHeadDoctorName(String headDoctorName) {
		this.headDoctorName = headDoctorName;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.setDepartment(this);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
        doctor.setDepartment(null);
    }

    public List<Doctor> getDoctors() { return doctors; }
}
