package com.bank;



import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditScoreValidator implements LoanValidator {

    public CreditScoreValidator() {
        System.out.println("CreditScoreValidator bean created");
    }

    @Override
    public void validateLoan(double amount) {
        System.out.println("Validating using Credit Score for amount: " + amount);
    }
}