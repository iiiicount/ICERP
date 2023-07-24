package com.count.icount.trade.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.count.icount.trade.bank.model.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
