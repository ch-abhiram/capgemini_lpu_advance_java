package com.url.Url_task.dao;




import java.time.LocalDateTime;

public class UrlResponseDto {

    private String shortCode;
    private String originalUrl;
    private Long clickCount;
    private LocalDateTime createdAt;

    public UrlResponseDto() {}

    public UrlResponseDto(String shortCode, String originalUrl,
                          Long clickCount, LocalDateTime createdAt) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
        this.clickCount = clickCount;
        this.createdAt = createdAt;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}