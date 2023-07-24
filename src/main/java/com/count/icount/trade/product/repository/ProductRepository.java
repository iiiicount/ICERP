package com.count.icount.trade.product.repository;

import com.count.icount.trade.product.model.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCompany_ComCode(String comCode, Pageable pageable);
}
