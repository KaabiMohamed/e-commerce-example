package com.shop.service.impl;

import com.shop.entity.Cart;
import com.shop.entity.Order;
import com.shop.mapper.OrderMapper;
import com.shop.repository.OrderRepository;
import com.shop.service.CartService;
import com.shop.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * This class provides order-related services in a shopping application.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    CartService cartService;
    @Autowired
    OrderRepository orderRepository;

    /**
     * Places a new order based on the current session cart.
     *
     * @return The newly placed order.
     * @throws IllegalArgumentException if the cart is empty.
     */
    @Override
    @Transactional
    public Order placeOrder() {
        Order order = OrderMapper.INSTANCE.mapFromCart(cartService.getSessionCart());
        if (order.isEmpty()) {
            throw new IllegalArgumentException("Could not place an empty order");
        }
        order.getEntries().forEach(entry -> entry.setOrder(order));
        Order savedOrder = orderRepository.save(order);
        cartService.flushCartInSession();
        return savedOrder;
    }

    /**
     * Retrieves an order based on its unique identifier.
     *
     * @param id The unique identifier of the order.
     * @return   The order corresponding to the given ID.
     * @throws   ResourceNotFoundException if the order is not found.
     */
    @Override
    public Order getOrderForId(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty())
            throw new ResourceNotFoundException(String.format("Could not find order with id %s", id));
        return order.get();
    }
}
