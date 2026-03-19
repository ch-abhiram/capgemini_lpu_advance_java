package com.example.recharge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RechargeResponse {
    private Long id;
    private String mobileNumber;
    private Double amount;
    private String status;
}
