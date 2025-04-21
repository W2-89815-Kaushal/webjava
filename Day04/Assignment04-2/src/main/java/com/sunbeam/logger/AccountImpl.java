package com.sunbeam.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountImpl {
    private double balance;

    @Autowired
    private Logger logger;

    public void deposit(double amount) {
        balance += amount;
        logger.log("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        balance -= amount;
        logger.log("Withdrawn: " + amount);
    }

    public double getBalance() {
        return balance;
    }
}
