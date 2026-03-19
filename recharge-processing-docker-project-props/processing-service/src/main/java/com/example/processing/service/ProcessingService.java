package com.example.processing.service;

import com.example.processing.entity.ProcessingRecord;
import com.example.processing.repository.ProcessingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessingService {

    private final ProcessingRepository processingRepository;

    public List<ProcessingRecord> getAllRecords() {
        return processingRepository.findAll();
    }
}
