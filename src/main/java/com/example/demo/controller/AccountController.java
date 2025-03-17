package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import com.example.demo.service.AccountService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/top-up")
    public Payment topUpAccount(
            @PathVariable Long accountId,
            @RequestParam BigDecimal amount) {
        return accountService.topUpAccount(accountId, amount);
    }

    @GetMapping("/payments/{paymentId}/status")
    public PaymentStatus checkPaymentStatus(
            @PathVariable Long paymentId) {
        return accountService.checkPaymentStatus(paymentId);
    }

    @PostMapping("/{accountId}/hold")
    public void holdFunds(
            @PathVariable Long accountId,
            @RequestParam BigDecimal amount) {
        accountService.holdFunds(accountId, amount);
    }

    @PostMapping("/{accountId}/charge")
    public void chargeAccount(
            @PathVariable Long accountId,
            @RequestParam BigDecimal amount) {
        accountService.chargeAccount(accountId, amount);
    }
}
