package com.bank;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AuditService {

    @PostConstruct
    public void init() {
        System.out.println("Audit Service initialized");
    }

    public void audit(String msg) {
        System.out.println("AUDIT: " + msg);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Audit Service destroyed");
    }
}