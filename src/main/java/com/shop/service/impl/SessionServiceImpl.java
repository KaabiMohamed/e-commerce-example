package com.shop.service.impl;

import com.shop.config.SessionConstants;
import com.shop.entity.Currency;
import com.shop.repository.CurrencyRepository;
import com.shop.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * This class provides session-related services in a shopping application.
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    CurrencyRepository currencyRepository;

    /**
     * Retrieves the current HTTP session.
     *
     * @return The HttpSession object representing the current session.
     */
    @Override
    public HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true creates a new session if one doesn't exist
    }

    /**
     * Sets the default currency for the session.
     */
    @Override
    public void setSessionDefaultCurrency() {
        Currency currency = currencyRepository.getReferenceById(SessionConstants.DEFAULT_CURRENCY_SESSION_ID);
        if (currency == null)
            throw new ResourceNotFoundException(String.format("Could not find currency %s", SessionConstants.DEFAULT_CURRENCY_SESSION_ID));
        getSession().setAttribute(SessionConstants.CURRENCY_SESSION_KEY, currency.getCurrency());
    }

    /**
     * Retrieves the currency stored in the session.
     *
     * @return The currency stored in the session as a string.
     */
    @Override
    public String getSessionCurrency() {
        String currentCurrency = (String) getSession().getAttribute(SessionConstants.CURRENCY_SESSION_KEY);

        if (currentCurrency == null || currentCurrency.isEmpty())
            setSessionDefaultCurrency();

        return (String) getSession().getAttribute(SessionConstants.CURRENCY_SESSION_KEY);
    }

    /**
     * Clears the session by removing currency and cart attributes.
     */
    @Override
    public void clearSession() {
        getSession().removeAttribute(SessionConstants.CURRENCY_SESSION_KEY);
        getSession().removeAttribute(SessionConstants.CART_SESSION_KEY);
    }
}
