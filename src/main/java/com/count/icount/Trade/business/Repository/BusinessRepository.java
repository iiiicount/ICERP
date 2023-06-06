package com.count.icount.Trade.business.Repository;

import com.count.icount.Trade.business.Model.Entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}
