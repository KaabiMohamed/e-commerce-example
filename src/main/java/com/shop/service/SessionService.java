package com.shop.service;

import javax.servlet.http.HttpSession;

/**
 * This interface defines methods for managing sessions in a shopping application.
 */
public interface SessionService {

    /**
     * Retrieves the current HTTP session.
     *
     * @return The HttpSession object representing the current session.
     */
    HttpSession getSession();

    /**
     * Sets the default currency for the session.
     */
    void setSessionDefaultCurrency();

    /**
     * Retrieves the currency stored in the session.
     *
     * @return The currency stored in the session as a string.
     */
    String getSessionCurrency();

    /**
     * Clears the session, removing all session attributes.
     */
    void clearSession();
}
