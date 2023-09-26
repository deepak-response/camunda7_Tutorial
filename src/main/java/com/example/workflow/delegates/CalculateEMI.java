package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import javax.inject.Named;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

@Component(value="calculateEMI")
public class CalculateEMI implements JavaDelegate {
    static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Executing Service task for Customer: "+delegateExecution.getVariable("customerName"));
        String loanAmount = "0.0";
        String category = "Gold";

        loanAmount = (String) delegateExecution.getVariable("loanAmount");

        double appliedLoanAmountDouble = Double.parseDouble(loanAmount);
        double emi = (appliedLoanAmountDouble/12);
        logger.info("EMI for Loan Amount " + loanAmount + " is: "+emi);


        delegateExecution.setVariable("emi", emi);
    }
}
