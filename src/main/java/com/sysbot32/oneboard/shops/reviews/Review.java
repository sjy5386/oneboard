package com.sysbot32.oneboard.shops.reviews;

import com.sysbot32.oneboard.shops.products.Product;
import com.sysbot32.oneboard.shops.products.ProductItem;
import com.sysbot32.oneboard.users.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    /* 상품 */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /* 옵션 */
    @ManyToOne
    @JoinColumn(name = "option_id")
    private ProductItem option;

    @ManyToOne
    private User user;

    /* 평점 */
    @Column(nullable = false)
    private Byte rating = 0;

    /* 요약 */
    private String summary;

    /* 상세 */
    private String detail;
}
