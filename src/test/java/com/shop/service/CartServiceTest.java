package com.shop.service;

import com.shop.entity.Cart;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class CartServiceTest {
    @Autowired
    CartService cartService;

    @Test
    @DisplayName("Test Get Cart In Session")
    void testGetCartInSession(){
        Cart cart = cartService.getSessionCart();
        assertNotNull(cart);
    }

    @Test
    @DisplayName("Test Add to Cart with multiple operations")
    void testAddtoCart(){
        //GIVEN
        Long productID = 1L;
        int quantity = 2;
        //WHEN
        cartService.addToCart(productID,quantity);
        //THEN
        Cart cart = cartService.getSessionCart();
        assertEquals(2,cart.getEntries().get(0).getQuantity());
        cartService.addToCart(productID,2);
        assertEquals(4,cart.getEntries().get(0).getQuantity());
        cartService.addToCart(productID,-1);
        assertEquals(3,cart.getEntries().get(0).getQuantity());
    }
}
