package com.url.Url_task.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.url.Url_task.Entity.UrlMapping;
import com.url.Url_task.dao.StatsDto;
import com.url.Url_task.dao.UrlRequestDto;
import com.url.Url_task.dao.UrlResponseDto;
import com.url.Url_task.repository.UrlMappingRepository;

@Service
public class UrlMappingServiceImpl implements UrlMappingService {

    private UrlMappingRepository repository;


    public UrlMappingServiceImpl(UrlMappingRepository repository) {
        this.repository = repository;
    }

    private static final String CHAR_SET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private String generateShortCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }

        return sb.toString();
    }

   
    @Override
    @Transactional
    public UrlResponseDto createShortUrl(UrlRequestDto request) {

        String shortCode;

     
        do {
            shortCode = generateShortCode();
        } while (repository.existsByShortCode(shortCode));

        UrlMapping mapping = new UrlMapping(
                request.getOriginalUrl(),
                shortCode,
                0L
        );

        repository.save(mapping);

        return new UrlResponseDto(
                mapping.getShortCode(),
                mapping.getOriginalUrl(),
                mapping.getClickCount(),
                mapping.getCreatedAt()
        );
    }

    @Override
    @Transactional
    public String resolveAndRedirect(String shortCode) {

        UrlMapping mapping = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short code not found"));

        mapping.setClickCount(mapping.getClickCount() + 1);

        return mapping.getOriginalUrl();
    }

   
    @Override
    public StatsDto getStats(String shortCode) {

        UrlMapping mapping = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short code not found"));

        return new StatsDto(
                mapping.getShortCode(),
                mapping.getOriginalUrl(),
                mapping.getClickCount(),
                mapping.getCreatedAt(),
                mapping.getUpdatedAt()
        );
    }

   
    @Override
    public List<UrlResponseDto> getTop5() {

        List<UrlMapping> topList =
                repository.findTop5ByClickCountDesc(PageRequest.of(0, 5));

        List<UrlResponseDto> responseList = new ArrayList<>();

        for (UrlMapping mapping : topList) {
            responseList.add(
                    new UrlResponseDto(
                            mapping.getShortCode(),
                            mapping.getOriginalUrl(),
                            mapping.getClickCount(),
                            mapping.getCreatedAt()
                    )
            );
        }

        return responseList;
    }
}