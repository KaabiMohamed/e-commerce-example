package com.shop.service;

import com.shop.entity.Cart;
import com.shop.entity.CartEntry;
import com.shop.entity.Product;

/**
 * This interface defines methods for managing shopping carts in a shopping application.
 */
public interface CartService {

    /**
     * Adds a specified quantity of a product to the shopping cart.
     *
     * @param productID The unique identifier of the product to add.
     * @param quantity  The quantity of the product to add to the cart.
     */
    void addToCart(Long productID, int quantity);

    /**
     * Retrieves the current shopping cart stored in the session.
     *
     * @return The shopping cart stored in the session.
     */
    Cart getSessionCart();

    /**
     * Updates the shopping cart stored in the session with the provided cart.
     *
     * @param cart The cart to update the session with.
     */
    void updateCartSession(Cart cart);

    /**
     * Creates a new cart entry for a product with the specified quantity.
     *
     * @param p        The product for which a cart entry is to be created.
     * @param quantity The quantity of the product in the cart entry.
     * @return         The newly created cart entry.
     */
    CartEntry createNewCartEntry(Product p, int quantity);

    /**
     * Removes the current shopping cart from the session.
     */
    void flushCartInSession();
}
