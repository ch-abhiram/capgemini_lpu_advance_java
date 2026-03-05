package com.url.Url_task.dao;



import jakarta.validation.constraints.NotBlank;

public class UrlRequestDto {

    @NotBlank(message = "Original URL must not be blank")
    private String originalUrl;

    private String customAlias;

    public UrlRequestDto() {}

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getCustomAlias() {
        return customAlias;
    }

    public void setCustomAlias(String customAlias) {
        this.customAlias = customAlias;
    }
}