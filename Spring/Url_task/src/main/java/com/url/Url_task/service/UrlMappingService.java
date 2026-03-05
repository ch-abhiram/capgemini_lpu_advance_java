package com.url.Url_task.service;



import java.util.List;

import com.url.Url_task.dao.StatsDto;
import com.url.Url_task.dao.UrlRequestDto;
import com.url.Url_task.dao.UrlResponseDto;

public interface UrlMappingService {

    UrlResponseDto createShortUrl(UrlRequestDto request);

    String resolveAndRedirect(String shortCode);

    StatsDto getStats(String shortCode);

    List<UrlResponseDto> getTop5();
}