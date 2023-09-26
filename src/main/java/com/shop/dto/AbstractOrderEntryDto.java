package com.shop.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * Represents a Data Transfer Object (DTO) for an abstract order entry.
 */
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractOrderEntryDto {

    /**
     * The product associated with the order entry.
     */
    private ProductDto product;

    /**
     * The quantity of the product in the order entry.
     */
    private int quantity;

    /**
     * The price before tax (excluding tax) for the order entry.
     */
    private BigDecimal priceHT;

    /**
     * The value-added tax (VAT) amount for the order entry.
     */
    private BigDecimal vat;

    /**
     * The net total price (including tax) for the order entry.
     */
    private BigDecimal netPrice;
}
