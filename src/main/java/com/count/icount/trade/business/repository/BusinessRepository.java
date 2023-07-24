package com.count.icount.trade.business.repository;

import com.count.icount.trade.business.model.entity.Business;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findAllByCompany_ComCode(String comCode, Pageable pageable);
}
