package com.shop.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Represents an abstract order entry with product, quantity, and pricing details.
 */
@MappedSuperclass
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractOrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The product associated with the order entry.
     */
    @ManyToOne
    private Product product;

    /**
     * The quantity of the product in the order entry.
     */
    @Column(nullable = false)
    private int quantity;

    /**
     * The price excluding tax (HT) of the product in the order entry.
     */
    @Column(nullable = false)
    private BigDecimal priceHT;

    /**
     * The value-added tax (VAT) amount for the product in the order entry.
     */
    @Column(nullable = false)
    private BigDecimal vat;

    /**
     * The VAT rate applied to the product in the order entry.
     */
    @Column(nullable = false)
    private BigDecimal vatRate;

    /**
     * The net price (including tax) of the product in the order entry.
     */
    @Column(nullable = false)
    private BigDecimal netPrice;
}
