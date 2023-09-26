package com.shop.service;

import com.shop.entity.Order;

import java.util.List;

/**
 * This interface defines methods for managing orders in a shopping application.
 */
public interface OrderService {

    /**
     * Places a new order.
     *
     * @return The newly placed order.
     */
    Order placeOrder();

    /**
     * Retrieves an order based on its unique identifier.
     *
     * @param id The unique identifier of the order.
     * @return The order corresponding to the given ID, or null if not found.
     */
    Order getOrderForId(Long id);
}
