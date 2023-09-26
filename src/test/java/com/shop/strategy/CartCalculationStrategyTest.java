package com.shop.strategy;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.shop.entity.Cart;
import com.shop.service.CartService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class CartCalculationStrategyTest {
    String[]netPrices = new String[10];
    @Autowired
    CartService cartService;
    @Autowired
    CalculationStrategy cartCalculationService;

    /**
     * TEST VALUES OF CART ENTRIES
     * @param cart from session
     */
    private void checkEntries(Cart cart) {
        cart.getEntries().forEach(cartEntry -> {
                assertEquals(netPrices[cartEntry.getProduct().getId().intValue()], cartEntry.getNetPrice().toString());
            });
    }

    @PostConstruct
    void initPricesToCheck() {
        netPrices[1] = "12.49";
        netPrices[2] = "16.49";
        netPrices[3] = "0.85";
        netPrices[4] = "10.50";
        netPrices[5] = "54.65";
        netPrices[6] = "32.19";
        netPrices[7] = "20.89";
        netPrices[8] = "9.75";
        netPrices[9] = "11.85";
    }

    /**
     * PRINT CART
     * @param cart from session
     */
    private void printMessage(Cart cart) {
        cart.getEntries().forEach(cartEntry -> {
                log.info(String.format("%s %s %s", cartEntry.getQuantity(), cartEntry.getProduct().getName(), cartEntry.getNetPrice()));
            });
        log.info(String.format("Sales Tax %s Total %s", cart.getVat(), cart.getNetPrice()));
    }

    @Test
    @DisplayName("Test Cart Calculation For Output 1")
    void testCartCalculationForOutput1() {
        cartService.addToCart(1L, 1);
        cartService.addToCart(2L, 1);
        cartService.addToCart(3L, 1);
        cartCalculationService.recalculate(cartService.getSessionCart());

        Cart cart = cartService.getSessionCart();

        printMessage(cart);
        checkEntries(cart);
        assertEquals("1.50", cart.getVat().toString());
        assertEquals("29.83", cart.getNetPrice().toString());
    }

    @Test
    @DisplayName("Test Cart Calculation For Output 2")
    void testCartCalculationForOutput2() {
        cartService.addToCart(4L, 1);
        cartService.addToCart(5L, 1);
        cartCalculationService.recalculate(cartService.getSessionCart());

        Cart cart = cartService.getSessionCart();

        printMessage(cart);
        checkEntries(cart);
        assertEquals("7.65", cart.getVat().toString());
        assertEquals("65.15", cart.getNetPrice().toString());
    }

    @Test
    @DisplayName("Test Cart Calculation For Output 3")
    void testCartCalculationForOutput3() {
        cartService.addToCart(6L, 1);
        cartService.addToCart(7L, 1);
        cartService.addToCart(8L, 1);
        cartService.addToCart(9L, 1);
        cartCalculationService.recalculate(cartService.getSessionCart());

        Cart cart = cartService.getSessionCart();

        printMessage(cart);
        checkEntries(cart);
        assertEquals("6.70", cart.getVat().toString());
        assertEquals("74.68", cart.getNetPrice().toString());
    }
}


