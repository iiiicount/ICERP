package com.count.icount.trade.sell.repository;

import com.count.icount.trade.sell.model.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SellRepository extends JpaRepository<Sell, Long> {
    Optional<Sell> findById(Long id);
    Optional<List<Sell>> findByComCode(String comCode);

    Optional<Sell> findByIdAndComCode(Long id, String Comcode);
}
