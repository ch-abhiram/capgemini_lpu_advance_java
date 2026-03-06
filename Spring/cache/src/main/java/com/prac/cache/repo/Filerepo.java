package com.prac.cache.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.cache.Entity.FileData;

public interface Filerepo extends JpaRepository<FileData, Integer>{

}
