package com.shop.service;

import com.shop.entity.Currency;
import com.shop.entity.Product;

import java.math.BigDecimal;

/**
 * This interface defines methods for managing product-related operations in a shopping application.
 */
public interface ProductService {

    /**
     * Retrieves a product based on its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return   The product corresponding to the given ID, or null if not found.
     */
    Product getProductForId(Long id);

    /**
     * Retrieves the price of a product.
     *
     * @param p The product for which the price is to be retrieved.
     * @return  The price of the product as a BigDecimal.
     */
    BigDecimal getPrice(Product p);

    /**
     * Retrieves the price of a product in a specific currency.
     *
     * @param p        The product for which the price is to be retrieved.
     * @param currency The currency in which the price should be expressed.
     * @return         The price of the product in the specified currency as a BigDecimal.
     */
    BigDecimal getPriceForCurrency(Product p, String currency);

    /**
     * Retrieves the tax rate for a product.
     *
     * @param p The product for which the tax rate is to be retrieved.
     * @return  The tax rate for the product as a BigDecimal.
     */
    BigDecimal getTaxRate(Product p);
}
