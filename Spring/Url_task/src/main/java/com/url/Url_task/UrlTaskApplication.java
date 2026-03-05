package com.url.Url_task;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.url.Url_task.repository.UrlMappingRepository;

@SpringBootApplication
public class UrlTaskApplication implements CommandLineRunner {

    @Autowired
    private UrlMappingRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(UrlTaskApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Total records in DB: " + repo.count());
    }
}