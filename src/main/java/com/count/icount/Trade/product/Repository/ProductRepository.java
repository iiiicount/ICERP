package com.count.icount.trade.product.Repository;

import com.count.icount.trade.product.Model.Entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCompany_ComCode(String comCode, Pageable pageable);
}
