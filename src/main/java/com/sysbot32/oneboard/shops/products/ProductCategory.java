package com.sysbot32.oneboard.shops.products;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    /* 이름 */
    @Column(nullable = false)
    private String name;

    /* 상위 카테고리 */
    @ManyToOne
    private ProductCategory parent;

    @OneToMany
    private List<ProductCategory> children;

    @OneToMany
    private List<Product> products;
}
