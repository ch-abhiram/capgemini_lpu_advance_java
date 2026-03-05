package com.bank;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BankAppConfig.class);

        LoanService service = context.getBean(LoanService.class);
        service.applyLoan(500000);

        context.close();
    }
}