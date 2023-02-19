package com.count.icount.trade.product.Repository;

import com.count.icount.trade.product.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
