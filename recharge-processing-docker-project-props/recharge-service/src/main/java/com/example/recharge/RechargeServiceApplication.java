package com.example.recharge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RechargeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RechargeServiceApplication.class, args);
    }
}
