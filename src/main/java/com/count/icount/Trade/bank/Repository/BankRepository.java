package com.count.icount.trade.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.count.icount.trade.bank.Model.Entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
