package com.shop.facade;

import com.shop.dto.CartDto;

/**
 * This interface defines the facade for shopping cart-related operations in a shopping application.
 */
public interface CartFacade {

    /**
     * Adds a specified quantity of a product to the shopping cart.
     *
     * @param productID The unique identifier of the product to add.
     * @param quantity  The quantity of the product to add to the cart.
     * @return          The CartDto representing the updated shopping cart.
     */
    CartDto addToCart(Long productID, int quantity);

    /**
     * Retrieves the current shopping cart and returns it as a CartDto.
     *
     * @return The CartDto representing the current shopping cart.
     */
    CartDto getShoppingCart();

    /**
     * Clears the contents of the shopping cart.
     */
    void clearCart();
}
