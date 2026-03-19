package com.example.processing.repository;

import com.example.processing.entity.ProcessingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessingRepository extends JpaRepository<ProcessingRecord, Long> {
}
