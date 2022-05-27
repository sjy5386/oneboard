package com.sysbot32.oneboard.shops.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findAllByProduct(Product product);

    List<ProductItem> findAllByProductAndIsHiddenFalse(Product product);

    List<ProductItem> findAllByProductAndIsHiddenFalseAndIsSoldOutFalse(Product product);
}
