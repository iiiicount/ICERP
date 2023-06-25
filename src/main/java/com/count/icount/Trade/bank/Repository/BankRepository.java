package com.count.icount.Trade.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.count.icount.Trade.bank.Model.Entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
