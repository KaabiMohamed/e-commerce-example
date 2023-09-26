package com.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a product with tax, category, and price.
 */
@Entity
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the product.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The tax group associated with the product.
     */
    @ManyToOne
    private TaxGroup tax;

    /**
     * The category of the product.
     */
    @ManyToOne
    private Category category;

    /**
     * The list of price rows associated with the product.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<PriceRow> price;

    /**
     * Indicates whether the product is imported.
     */
    @Column(nullable = false)
    private boolean isImported;
}
