package com.count.icount.Trade.sell.Repository;

import com.count.icount.Trade.sell.Model.Entity.Sell;
import com.count.icount.Trade.sell.Model.Entity.SellDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SellRepository extends JpaRepository<Sell, Long> {
    Optional<Sell> findById(Long id);
    Optional<List<Sell>> findByComCode(String comCode);

    Optional<Sell> findByIdAndComCode(Long id, String Comcode);
}
