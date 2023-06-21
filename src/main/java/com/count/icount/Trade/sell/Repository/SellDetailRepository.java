package com.count.icount.Trade.sell.Repository;

import com.count.icount.Trade.sell.Model.Entity.SellDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellDetailRepository extends JpaRepository<SellDetail, Long> {
    Optional<SellDetail> findById(Long id);
}
