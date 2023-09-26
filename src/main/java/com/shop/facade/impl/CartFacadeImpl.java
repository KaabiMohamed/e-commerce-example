package com.shop.facade.impl;

import com.shop.dto.CartDto;
import com.shop.facade.CartFacade;
import com.shop.mapper.CartMapper;
import com.shop.service.CartService;
import com.shop.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class provides shopping cart-related facade services in a shopping application.
 */
@Service
public class CartFacadeImpl implements CartFacade {
    @Autowired
    CartService cartService;

    /**
     * Adds a specified quantity of a product to the shopping cart and returns the updated CartDto.
     *
     * @param productID The unique identifier of the product to add.
     * @param quantity  The quantity of the product to add to the cart.
     * @return          The CartDto representing the updated shopping cart.
     */
    @Override
    public CartDto addToCart(Long productID, int quantity) {
        cartService.addToCart(productID, quantity);
        return getShoppingCart();
    }

    /**
     * Retrieves the current shopping cart and returns it as a CartDto.
     *
     * @return The CartDto representing the current shopping cart.
     */
    @Override
    public CartDto getShoppingCart() {
        return CartMapper.INSTANCE.mapToDto(cartService.getSessionCart());
    }

    /**
     * Clears the contents of the shopping cart.
     */
    @Override
    public void clearCart() {
        cartService.flushCartInSession();
    }
}
