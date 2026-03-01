package com.capgemini.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.HMS.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
