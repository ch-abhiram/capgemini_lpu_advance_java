package com.bank;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoanService {

    private LoanValidator loanValidator;
    private AuditService auditService;

    @Autowired
    public LoanService(@Qualifier("incomeValidator") LoanValidator loanValidator) {
        this.loanValidator = loanValidator;
    }

    @Autowired
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void applyLoan(double amount) {
        loanValidator.validateLoan(amount);
        auditService.audit("Loan processed for amount: " + amount);
    }
}
