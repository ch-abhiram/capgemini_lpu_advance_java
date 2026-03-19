package com.example.recharge.client;

import com.example.recharge.dto.ProcessorCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "processing-service")
public interface ProcessingFeignClient {

    @GetMapping("/internal/processor-check")
    ProcessorCheckResponse checkProcessor();
}
