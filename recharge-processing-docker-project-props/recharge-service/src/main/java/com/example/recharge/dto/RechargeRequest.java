package com.example.recharge.dto;

import lombok.Data;

@Data
public class RechargeRequest {
    private String mobileNumber;
    private Double amount;
}
