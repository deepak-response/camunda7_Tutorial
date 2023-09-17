package com.example.workflow.controllers;

import model.CustomerInput;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin
public class LearningController {
    static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @RequestMapping(value = "/getconnector/{loanType}", method = RequestMethod.GET)
    public String getConnector(@PathVariable String loanType) {
        //return name.length();
        String reviewAction = "approved";
        logger.info("Customer has applied for " + loanType + " Loan: ");

        if (loanType.equalsIgnoreCase("home")) {
            reviewAction = "approve";
        } else if (loanType.equalsIgnoreCase("personal")) {
            reviewAction = "reject";
        }
        return reviewAction;
    }

    @RequestMapping(value = "/postconnector", method = RequestMethod.POST)
    public int postConnector(@RequestBody CustomerInput customerInput) {
        return customerInput.getLoanAmount() + customerInput.getAge();
    }
    @GetMapping("/getReviewAction")
    public String getReviewAction(@RequestBody String loanType) {
        String reviewAction = "approved";
        logger.info("Customer has applied for " + loanType + " Loan: ");

        if (loanType.equalsIgnoreCase("home")) {
            reviewAction = "approve";
        } else if (loanType.equalsIgnoreCase("personal")) {
            reviewAction = "reject";
        }
        return reviewAction;
    }

}
