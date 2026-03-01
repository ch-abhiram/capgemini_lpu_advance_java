package com.capgemini.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.HMS.Entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
