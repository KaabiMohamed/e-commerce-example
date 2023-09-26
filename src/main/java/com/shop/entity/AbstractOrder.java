package com.shop.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Represents an abstract order with pricing details.
 */
@MappedSuperclass
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The total price excluding tax (HT) for the order.
     */
    @Column(nullable = false)
    private BigDecimal priceHT;

    /**
     * The total value-added tax (VAT) amount for the order.
     */
    @Column(nullable = false)
    private BigDecimal vat;

    /**
     * The total net price (including tax) for the order.
     */
    @Column(nullable = false)
    private BigDecimal netPrice;
}
