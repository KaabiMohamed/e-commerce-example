package com.shop.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Represents a tax rate.
 */
@Entity
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The tax rate value.
     */
    @Column(nullable = false)
    private BigDecimal taxRate;
}
