package com.example.service.serv;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.service.config.RabbitConfig;
import com.example.service.dto.RechargeProducerDTO;

@Service
public class RechargeService {

	private final RabbitTemplate rabbitTemplate;
	
	public RechargeService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public String sendRechargeRequest(RechargeProducerDTO dto) {
		rabbitTemplate.convertAndSend(RabbitConfig.Queue_Name, dto);
		return "message has been sent to broker";
	}
	
	
	
}
