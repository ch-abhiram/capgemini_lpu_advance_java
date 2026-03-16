package com.docker_database.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker_database.Entity.Student;

public interface Studentrepo extends JpaRepository<Student, Long>{

}
