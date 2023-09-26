package com.shop.config;

/**
 * Constants for session keys and default values related to user sessions.
 */
public class SessionConstants {
    /**
     * The session key for storing the shopping cart.
     */
    public static final String CART_SESSION_KEY = "cart";

    /**
     * The session key for storing the selected currency.
     */
    public static final String CURRENCY_SESSION_KEY = "currency";

    /**
     * The default currency session ID (e.g., "EUR").
     */
    public static final String DEFAULT_CURRENCY_SESSION_ID = "EUR";
}
