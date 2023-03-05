package com.count.icount.Trade.product.Repository;

import com.count.icount.Trade.product.Model.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
    Optional<Product> findById(Long id);
}
