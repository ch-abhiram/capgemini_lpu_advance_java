package com.example.recharge.service;

import com.example.recharge.client.ProcessingFeignClient;
import com.example.recharge.config.RabbitConfig;
import com.example.recharge.dto.ProcessorCheckResponse;
import com.example.recharge.dto.RechargeEvent;
import com.example.recharge.dto.RechargeRequest;
import com.example.recharge.dto.RechargeResponse;
import com.example.recharge.entity.Recharge;
import com.example.recharge.repository.RechargeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RechargeService {

    private final RechargeRepository rechargeRepository;
    private final ProcessingFeignClient processingFeignClient;
    private final RabbitTemplate rabbitTemplate;

    public RechargeResponse createRecharge(RechargeRequest request) {
        ProcessorCheckResponse processorCheck = processingFeignClient.checkProcessor();

        Recharge recharge = Recharge.builder()
                .mobileNumber(request.getMobileNumber())
                .amount(request.getAmount())
                .status("CREATED - " + processorCheck.getMessage())
                .build();

        Recharge savedRecharge = rechargeRepository.save(recharge);

        RechargeEvent rechargeEvent = new RechargeEvent(
                savedRecharge.getId(),
                savedRecharge.getMobileNumber(),
                savedRecharge.getAmount()
        );

        rabbitTemplate.convertAndSend(RabbitConfig.RECHARGE_QUEUE, rechargeEvent);

        return new RechargeResponse(
                savedRecharge.getId(),
                savedRecharge.getMobileNumber(),
                savedRecharge.getAmount(),
                savedRecharge.getStatus()
        );
    }

    public RechargeResponse getRechargeById(Long id) {
        Recharge recharge = rechargeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recharge not found with id: " + id));

        return new RechargeResponse(
                recharge.getId(),
                recharge.getMobileNumber(),
                recharge.getAmount(),
                recharge.getStatus()
        );
    }
}
