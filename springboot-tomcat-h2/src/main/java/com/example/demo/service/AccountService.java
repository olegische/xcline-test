package com.example.demo.service;

import com.example.demo.model.Account;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {

    // Метод для пополнения счета
    public void topUp(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    // Метод для проверки состояния пополнения
    public boolean checkTopUpStatus(Account account) {
        return account.getBalance() > 0;
    }

    // Метод для холдирования средств за услугу
    public void holdFundsForService(Account account, double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }

    // Метод для списания средств за услугу
    public void deductAmountForService(Account account, double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }
}
