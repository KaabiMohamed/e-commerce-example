package com.shop.repository;

import com.shop.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository provides access to currency data in a shopping application.
 */
public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
