package com.shop.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * Represents a Data Transfer Object (DTO) for an abstract order.
 */
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractOrderDto {

    /**
     * The price before tax (excluding tax) for the order.
     */
    private BigDecimal priceHT;

    /**
     * The value-added tax (VAT) amount for the order.
     */
    private BigDecimal vat;

    /**
     * The net total price (including tax) for the order.
     */
    private BigDecimal netPrice;
}
