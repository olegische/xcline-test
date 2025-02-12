package com.example.demo.controller;

import com.example.demo.service.AccountService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Метод для пополнения счета
    @RequestMapping(value = "/{id}/top-up", method = RequestMethod.POST)
    public ResponseEntity<String> topUp(@PathVariable("id") Long id, @RequestBody Double amount) {
        Account account = new Account(id, "name", amount);
        accountService.topUp(account, amount);
        return ResponseEntity.ok().build();
    }

    // Метод для проверки состояния пополнения
    @RequestMapping(value = "/{id}/check-top-up-status", method = RequestMethod.GET)
    public ResponseEntity<Boolean> checkTopUpStatus(@PathVariable("id") Long id) {
        Account account = new Account(id, "name", 0.0);
        Boolean status = accountService.checkTopUpStatus(account);
        return ResponseEntity.ok(status).build();
    }

    // Метод для холдирования средств за услугу
    @RequestMapping(value = "/{id}/hold-funds-for-service/{amount}", method = RequestMethod.PUT)
    public ResponseEntity<Void> holdFundsForService(@PathVariable("id") Long id, @PathVariable("amount") Double amount) {
        Account account = new Account(id, "name", amount);
        accountService.holdFundsForService(account, amount);
        return ResponseEntity.noContent().build();
    }

    // Метод для списания средств за услугу
    @RequestMapping(value = "/{id}/deduct-amount-for-service/{amount}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deductAmountForService(@PathVariable("id") Long id, @PathVariable("amount") Double amount) {
        Account account = new Account(id, "name", amount);
        accountService.deductAmountForService(account, amount);
        return ResponseEntity.noContent().build();
    }
}
