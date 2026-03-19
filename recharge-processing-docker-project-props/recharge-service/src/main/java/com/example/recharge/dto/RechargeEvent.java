package com.example.recharge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargeEvent {
    private Long rechargeId;
    private String mobileNumber;
    private Double amount;
}
