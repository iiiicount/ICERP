package com.count.icount.Trade.product.Repository;

import com.count.icount.Trade.product.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
