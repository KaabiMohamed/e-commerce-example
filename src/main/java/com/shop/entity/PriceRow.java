package com.shop.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Represents a price row with currency.
 */
@Entity
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The price value.
     */
    @Column(nullable = false)
    private double price;

    /**
     * The currency associated with the price.
     */
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
}
