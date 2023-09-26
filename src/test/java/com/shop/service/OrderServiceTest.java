package com.shop.service;

import com.shop.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @PostConstruct
    void prepareCartInSession(){
        cartService.addToCart(1L,1);
        cartService.addToCart(2L,1);
        cartService.addToCart(3L,1);
    }
    @Test
    @DisplayName("Place an order and success")
    void placeOrderTest(){
        //WHEN
        Order order = orderService.placeOrder();
        Order orderFromDatabase = orderService.getOrderForId(order.getId());
        //THEN
        assertEquals(order.getVat(),orderFromDatabase.getVat());
        assertEquals(order.getNetPrice(),orderFromDatabase.getNetPrice());
        assertEquals(order.getPriceHT(),orderFromDatabase.getPriceHT());
        assertEquals(order.getEntries().size(),orderFromDatabase.getEntries().size());
    }

    @Test
    @DisplayName("Place an order when cart is empty and fail")
    void placeOrderWhenCartIsEmpty(){
        cartService.flushCartInSession();
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.placeOrder();
        });

    }
}
