package com.count.icount.Trade.business.Repository;

import com.count.icount.Trade.business.Model.Entity.Business;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findAllByCompany_ComCode(String comCode, Pageable pageable);
}
