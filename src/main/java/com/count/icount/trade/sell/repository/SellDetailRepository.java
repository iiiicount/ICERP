package com.count.icount.trade.sell.repository;

import com.count.icount.trade.sell.model.entity.SellDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SellDetailRepository extends JpaRepository<SellDetail, Long> {
    Optional<SellDetail> findById(Long id);
    Optional<List<SellDetail>> findByComCode(String comCode);

    Optional<SellDetail> findByIdAndComCode(Long id, String Comcode);
}
