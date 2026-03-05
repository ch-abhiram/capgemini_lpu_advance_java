package com.url.Url_task.controller;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url.Url_task.dao.StatsDto;
import com.url.Url_task.dao.UrlRequestDto;
import com.url.Url_task.dao.UrlResponseDto;
import com.url.Url_task.service.UrlMappingService;

@RestController
@RequestMapping("/api")
public class UrlMappingController {

    private UrlMappingService service;

    public UrlMappingController(UrlMappingService service) {
        this.service = service;
    }

   
    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDto> createShortUrl(
            @RequestBody UrlRequestDto request) {

        UrlResponseDto response = service.createShortUrl(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = service.resolveAndRedirect(shortCode);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", originalUrl);

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

   
    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<StatsDto> getStats(
            @PathVariable String shortCode) {

        StatsDto stats = service.getStats(shortCode);

        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

  
    @GetMapping("/top")
    public ResponseEntity<?> getTop5() {

        return new ResponseEntity<>(service.getTop5(), HttpStatus.OK);
    }
}
