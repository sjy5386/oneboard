package com.sysbot32.oneboard.shops.reviews;

import com.sysbot32.oneboard.shops.products.Product;
import com.sysbot32.oneboard.shops.products.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByProduct(Product product);

    List<Review> findAllByOption(ProductItem option);

    List<Review> findAllByRating(Byte rating);
}
