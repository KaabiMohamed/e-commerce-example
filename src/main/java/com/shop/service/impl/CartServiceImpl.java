package com.shop.service.impl;

import com.shop.config.SessionConstants;
import com.shop.entity.Cart;
import com.shop.entity.CartEntry;
import com.shop.entity.Product;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import com.shop.service.SessionService;
import com.shop.strategy.CalculationStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * This class provides shopping cart-related services in a shopping application.
 */
@Service
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    SessionService sessionService;

    @Autowired
    ProductService productService;
    @Autowired
    CalculationStrategy cartCalculationService;

    /**
     * Adds a specified quantity of a product to the shopping cart.
     *
     * @param productID The unique identifier of the product to add.
     * @param quantity  The quantity of the product to add to the cart.
     */
    @Override
    public void addToCart(Long productID, int quantity) {
        Product product = productService.getProductForId(productID);
        Cart cartInSession = getSessionCart();
        Optional<CartEntry> cartEntry = cartInSession.getEntries().stream()
                .filter(entry -> productID.equals(entry.getProduct().getId()))
                .findFirst();
        if (cartEntry.isPresent()) {
            cartInSession.getEntries().forEach(entry -> {
                if (entry.getProduct().getId().equals(cartEntry.get().getProduct().getId())) {
                    entry.setQuantity(entry.getQuantity() + quantity);
                }
            });
        } else {
            cartInSession.getEntries().add(createNewCartEntry(product, quantity));
        }
        updateCartSession(cartInSession);
    }

    /**
     * Retrieves the shopping cart stored in the user's session.
     *
     * @return The shopping cart stored in the session.
     */
    @Override
    public Cart getSessionCart() {
        Cart cartInSession = (Cart) sessionService.getSession().getAttribute(SessionConstants.CART_SESSION_KEY);
        if (cartInSession == null) {
            if (log.isDebugEnabled())
                log.debug("Creating a new Cart in session");
            Cart cart = new Cart();
            cart.setEntries(new ArrayList<>());
            sessionService.getSession().setAttribute(SessionConstants.CART_SESSION_KEY, cart);
            return (Cart) sessionService.getSession().getAttribute(SessionConstants.CART_SESSION_KEY);
        }
        return cartInSession;
    }

    /**
     * Updates the shopping cart stored in the session with the provided cart.
     *
     * @param cart The cart to update the session with.
     */
    @Override
    public void updateCartSession(Cart cart) {
        cartCalculationService.recalculate(cart);
        sessionService.getSession().setAttribute(SessionConstants.CART_SESSION_KEY, cart);
    }

    /**
     * Creates a new cart entry for a product with the specified quantity.
     *
     * @param p        The product for which a cart entry is to be created.
     * @param quantity The quantity of the product in the cart entry.
     * @return         The newly created cart entry.
     */
    @Override
    public CartEntry createNewCartEntry(Product p, int quantity) {
        CartEntry entry = new CartEntry();
        entry.setQuantity(quantity);
        entry.setProduct(p);
        return entry;
    }

    /**
     * Removes the current shopping cart from the session.
     */
    @Override
    public void flushCartInSession() {
        Cart cart = new Cart();
        cart.setEntries(new ArrayList<>());
        sessionService.getSession().setAttribute(SessionConstants.CART_SESSION_KEY, cart);
    }
}
