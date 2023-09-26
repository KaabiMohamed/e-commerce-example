package com.shop.service;

import com.shop.entity.*;

/**
 * This interface defines methods for calculating prices for products and shopping carts in a shopping application.
 */
public interface PriceCalculationService {

    /**
     * Calculates the price for a product in the specified currency.
     *
     * @param p        The product for which the price is to be calculated.
     * @param c        The currency in which the price should be calculated.
     * @return         A PriceRow object representing the calculated price.
     */
    PriceRow calculateProductPrice(Product p, Currency c);

    /**
     * Calculates the price for a cart entry in the specified currency.
     *
     * @param entry    The cart entry for which the price is to be calculated.
     * @param c        The currency in which the price should be calculated.
     */
    void calculateCartEntry(CartEntry entry, Currency c);

    /**
     * Calculates the price for a cart entry.
     *
     * @param entry    The cart entry for which the price is to be calculated.
     */
    void calculateCartEntry(CartEntry entry);

    /**
     * Calculates the prices for a shopping cart in the specified currency.
     *
     * @param cart     The shopping cart for which the prices should be calculated.
     * @param c        The currency in which the prices should be calculated.
     */
    void calculateCart(Cart cart, Currency c);

    /**
     * Calculates the prices for a shopping cart.
     *
     * @param cart     The shopping cart for which the prices should be calculated.
     */
    void calculateCart(Cart cart);
}
