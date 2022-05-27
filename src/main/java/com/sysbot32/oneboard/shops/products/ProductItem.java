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
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /* 옵션 1 타입 */
    @Column(nullable = false)
    private String optionType1;
    /* 옵션 1 내부 이름 */
    @Column(nullable = false)
    private String optionName1;
    /* 옵션 1 이름 */
    @Column(nullable = false)
    private String optionDisplayName1;

    /* 옵션 2 타입 */
    private String optionType2;
    /* 옵션 2 내부 이름 */
    private String optionName2;
    /* 옵션 2 이름 */
    private String optionDisplayName2;

    /* 옵션 3 타입 */
    private String optionType3;
    /* 옵션 3 내부 이름 */
    private String optionName3;
    /* 옵션 3 이름 */
    private String optionDisplayName3;

    /* 숨김 */
    @Column(nullable = false)
    private Boolean isHidden = false;

    /* 품절 */
    @Column(nullable = false)
    private Boolean isSoldOut = false;

    /* 추가 가격 */
    @Column(nullable = false)
    private BigDecimal additionalPrice = BigDecimal.ZERO;

    /* 재고 */
    @Column(nullable = false)
    private Integer stockQuantity = 0;
}
