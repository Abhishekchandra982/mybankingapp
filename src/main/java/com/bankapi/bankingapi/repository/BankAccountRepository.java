package com.bankapi.bankingapi.repository;

import com.bankapi.bankingapi.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}