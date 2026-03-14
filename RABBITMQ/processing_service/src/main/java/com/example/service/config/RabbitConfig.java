package com.example.service.config;

import java.util.HashMap;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String Queue_Name = "recharge.queue";
    public static final String DLQ = "recharge.dlq";

    @Bean
    public Queue rechargeQueue() {

        HashMap<String, Object> args = new HashMap<>();

        args.put("x-message-ttl", 100000);
        args.put("x-dead-letter-exchange", "");
        args.put("x-dead-letter-routing-key", DLQ);

        return new Queue(Queue_Name, true, false, false, args);
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DLQ, true);
    }
}