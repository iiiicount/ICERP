package com.count.icount.Trade.sell.Repository;

import com.count.icount.Trade.sell.Model.Entity.SellDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface SellDetailRepository extends JpaRepository<SellDetail, Long> {
    Optional<SellDetail> findById(Long id);
    Optional<List<SellDetail>> findByComCode(String comCode);

    Optional<SellDetail> findByIdAndComCode(Long id, String Comcode);
}
