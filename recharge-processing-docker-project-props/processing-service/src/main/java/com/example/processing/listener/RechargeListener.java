package com.example.processing.listener;

import com.example.processing.config.RabbitConfig;
import com.example.processing.dto.RechargeEvent;
import com.example.processing.entity.ProcessingRecord;
import com.example.processing.repository.ProcessingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RechargeListener {

    private final ProcessingRepository processingRepository;

    @RabbitListener(queues = RabbitConfig.RECHARGE_QUEUE)
    public void consumeRecharge(RechargeEvent event) {
        ProcessingRecord record = ProcessingRecord.builder()
                .rechargeId(event.getRechargeId())
                .mobileNumber(event.getMobileNumber())
                .amount(event.getAmount())
                .processingStatus("PROCESSED")
                .build();

        processingRepository.save(record);
    }
}
