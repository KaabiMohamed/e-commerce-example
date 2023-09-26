package com.shop.facade;

import com.shop.dto.OrderDto;

/**
 * This interface defines the facade for order-related operations in a shopping application.
 */
public interface OrderFacade {

    /**
     * Places a new order and returns the corresponding OrderDto.
     *
     * @return The OrderDto representing the newly placed order.
     */
    OrderDto placeOrder();

    /**
     * Retrieves an order by its unique identifier and returns the corresponding OrderDto.
     *
     * @param id The unique identifier of the order to retrieve.
     * @return   The OrderDto representing the retrieved order.
     */
    OrderDto getOrderForID(Long id);
}
