package com.shop.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a currency.
 */
@Entity
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Currency implements Serializable {

    /**
     * The currency code (e.g., USD, EUR).
     */
    @Id
    private String currency;

    /**
     * The currency symbol (e.g., $, €).
     */
    @Column(nullable = false)
    private String symbol;
}
