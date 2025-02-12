package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @PostMapping("/top-up")
    public String topUp(@RequestParam("amount") int amount) {
        // Логика для пополнения счета
        return "Счет пополнен на " + amount + " рублей.";
    }

    @GetMapping("/check-status")
    public String checkStatus() {
        // Логика для проверки статуса пополнения
        return "Статус пополнения: успешно.";
    }

    @PutMapping("/hold")
    public String holdAmount(@RequestParam("amount") int amount) {
        // Логика для холдирования средств
        return "Холдировано " + amount + " рублей.";
    }

    @DeleteMapping("/deduct")
    public String deductAmount(@RequestParam("amount") int amount) {
        // Логика для списания средств
        return "Спишется " + amount + " рублей.";
    }
}
