package com.shop.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Represents a Data Transfer Object (DTO) for a shopping cart.
 */
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto extends AbstractOrderDto {

    /**
     * The list of entries in the shopping cart.
     */
    private List<CartEntryDto> entries;
}
