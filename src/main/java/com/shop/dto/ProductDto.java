package com.shop.dto;

import lombok.*;

/**
 * Represents a Data Transfer Object (DTO) for a product.
 */
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    /**
     * The ID of the product.
     */
    private Long id;

    /**
     * The name of the product.
     */
    private String name;
}
