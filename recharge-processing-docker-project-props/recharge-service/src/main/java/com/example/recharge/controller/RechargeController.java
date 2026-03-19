package com.example.recharge.controller;

import com.example.recharge.dto.RechargeRequest;
import com.example.recharge.dto.RechargeResponse;
import com.example.recharge.service.RechargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recharges")
@RequiredArgsConstructor
public class RechargeController {

    private final RechargeService rechargeService;

    @PostMapping
    public RechargeResponse createRecharge(@RequestBody RechargeRequest request) {
        return rechargeService.createRecharge(request);
    }

    @GetMapping("/{id}")
    public RechargeResponse getRechargeById(@PathVariable Long id) {
        return rechargeService.getRechargeById(id);
    }
}
