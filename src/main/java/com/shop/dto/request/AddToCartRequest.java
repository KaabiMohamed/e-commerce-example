package com.shop.dto.request;

import lombok.*;

/**
 * Represents a request DTO for adding a product to the shopping cart.
 */
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartRequest {
    /**
     * The ID of the product to add to the cart.
     */
    private Long productID;

    /**
     * The quantity of the product to add to the cart.
     */
    private int quantity;
}
