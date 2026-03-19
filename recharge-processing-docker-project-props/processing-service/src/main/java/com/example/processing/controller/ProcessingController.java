package com.example.processing.controller;

import com.example.processing.dto.ProcessorCheckResponse;
import com.example.processing.entity.ProcessingRecord;
import com.example.processing.service.ProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProcessingController {

    private final ProcessingService processingService;

    @GetMapping("/api/processings")
    public List<ProcessingRecord> getAllRecords() {
        return processingService.getAllRecords();
    }

    @GetMapping("/internal/processor-check")
    public ProcessorCheckResponse checkProcessor() {
        return new ProcessorCheckResponse("PROCESSOR_READY");
    }
}
