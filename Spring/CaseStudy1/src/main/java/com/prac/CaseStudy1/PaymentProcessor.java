package com.prac.CaseStudy1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

    private final PaymentService paymentService;

    @Autowired
    private TransactionLogger logger;

    public PaymentProcessor(
            @Qualifier("upiPayment") PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("PaymentProcessor Bean Created");
    }

    public void makePayment(double amount) {
        paymentService.processPayment(amount);
        logger.log("Payment Processed Successfully");
    }
}
