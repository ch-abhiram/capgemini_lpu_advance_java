package com.prac.CaseStudy1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements PaymentService {

    private final TransactionLogger logger;

    public UpiPayment(TransactionLogger logger) {
        this.logger = logger;
        System.out.println("UpiPayment Bean Created");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment: " + amount);
        logger.log("UPI Payment Done");
    }
}