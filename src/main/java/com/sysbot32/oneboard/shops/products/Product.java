package com.sysbot32.oneboard.shops.products;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    /* 내부 상품명 */
    @Column(nullable = false)
    private String name;

    /* 상품명 */
    @Column(nullable = false)
    private String displayName;

    /* 가격 */
    @Column(nullable = false)
    private BigDecimal price;

    /* 할인가 */
    private BigDecimal discountedPrice;

    /* 카테고리 */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    /* 설명 */
    private String description;

    /* 숨김 */
    @Column(nullable = false)
    private Boolean isHidden = false;

    /* 품절 */
    @Column(nullable = false)
    private Boolean isSoldOut = false;
}
