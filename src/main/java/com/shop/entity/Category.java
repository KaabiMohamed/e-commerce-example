package com.shop.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * Represents a product category.
 */
@Entity
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the category.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The list of products associated with the category.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}
