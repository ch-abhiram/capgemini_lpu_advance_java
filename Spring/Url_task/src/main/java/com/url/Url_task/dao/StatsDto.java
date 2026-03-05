package com.url.Url_task.dao;


import java.time.LocalDateTime;

public class StatsDto {

    private String shortCode;
    private String originalUrl;
    private Long clickCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StatsDto() {}

    public StatsDto(String shortCode, String originalUrl,
                    Long clickCount, LocalDateTime createdAt,
                    LocalDateTime updatedAt) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
        this.clickCount = clickCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getShortCode() { return shortCode; }
    public String getOriginalUrl() { return originalUrl; }
    public Long getClickCount() { return clickCount; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}