package com.bankapi.bankingapi.controller;

import com.bankapi.bankingapi.model.BankAccount;
import com.bankapi.bankingapi.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/create")
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return bankService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Optional<BankAccount> getAccount(@PathVariable Long id) {
        return bankService.getAccount(id);
    }

    @PostMapping("/{id}/deposit")
    public BankAccount deposit(@PathVariable Long id, @RequestParam double amount) {
        return bankService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public BankAccount withdraw(@PathVariable Long id, @RequestParam double amount) {
        return bankService.withdraw(id, amount);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam double amount) {
        bankService.transfer(fromId, toId, amount);
        return "Transfer successful";
    }
}
//aaddddddddddddddddddddddddddd
/// abcd efgh ig jjlkajlk