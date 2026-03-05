package com.bank;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IncomeValidator implements LoanValidator {

    public IncomeValidator() {
        System.out.println("IncomeValidator bean created");
    }

    @Override
    public void validateLoan(double amount) {
        System.out.println("Validating using Income for amount: " + amount);
    }
}