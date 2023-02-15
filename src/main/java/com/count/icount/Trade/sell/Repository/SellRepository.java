package com.count.icount.Trade.sell.Repository;

import com.count.icount.Trade.sell.Model.Entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellRepository extends JpaRepository<Sell, Long> {
    Optional<Sell> findById(Long id);
}
