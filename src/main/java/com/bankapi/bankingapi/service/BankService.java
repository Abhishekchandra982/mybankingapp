package com.bankapi.bankingapi.service;

import com.bankapi.bankingapi.model.BankAccount;
import com.bankapi.bankingapi.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class BankService {

    @Autowired
    private BankAccountRepository repository;

    public BankAccount createAccount(BankAccount account) {
        return repository.save(account);
    }

    public Optional<BankAccount> getAccount(Long id) {
        return repository.findById(id);
    }

    public BankAccount deposit(Long id, double amount) {
        BankAccount account = repository.findById(id).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        return repository.save(account);
    }

    public BankAccount withdraw(Long id, double amount) {
        BankAccount account = repository.findById(id).orElseThrow();
        if (account.getBalance() < amount) throw new RuntimeException("Insufficient balance");
        account.setBalance(account.getBalance() - amount);
        return repository.save(account);
    }

    public void transfer(Long fromId, Long toId, double amount) {
        BankAccount from = withdraw(fromId, amount);
        deposit(toId, amount);
    }
}
