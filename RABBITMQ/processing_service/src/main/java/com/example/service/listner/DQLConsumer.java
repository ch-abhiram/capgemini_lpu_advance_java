package com.example.service.listner;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.service.config.RabbitConfig;
import com.example.service.dto.RechargeProducerDTO;

@Component
public class DQLConsumer {
	@RabbitListener(queues = RabbitConfig.DLQ)
	public void readFailMesssage(RechargeProducerDTO request) {
		System.out.println("Failed Message");
	}
}
