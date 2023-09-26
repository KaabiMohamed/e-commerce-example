package com.shop.facade.impl;

import com.shop.dto.OrderDto;
import com.shop.entity.Order;
import com.shop.facade.OrderFacade;
import com.shop.mapper.OrderMapper;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class provides order-related facade services in a shopping application.
 */
@Service
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    OrderService orderService;

    /**
     * Places a new order and returns the corresponding OrderDto.
     *
     * @return The OrderDto representing the newly placed order.
     */
    @Override
    public OrderDto placeOrder() {
        Order order = orderService.placeOrder();
        return OrderMapper.INSTANCE.mapToDto(order);
    }

    /**
     * Retrieves an order by its unique identifier and returns the corresponding OrderDto.
     *
     * @param id The unique identifier of the order to retrieve.
     * @return   The OrderDto representing the retrieved order.
     */
    @Override
    public OrderDto getOrderForID(Long id) {
        return OrderMapper.INSTANCE.mapToDto(orderService.getOrderForId(id));
    }
}
