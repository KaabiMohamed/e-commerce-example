package com.shop.repository;

import com.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * This repository provides access to product data in a shopping application.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

        /**
         * Retrieves the price of a product in the specified currency.
         *
         * @param productID The unique identifier of the product.
         * @param currency  The currency in which the price should be retrieved.
         * @return          The price of the product in the specified currency as a BigDecimal.
         */
        @Query(value = "SELECT pr.price FROM product p LEFT JOIN price_row pr ON p.id = pr.product_id WHERE p.id = :product_id AND pr.currency_id = :currency", nativeQuery = true)
        BigDecimal getHTPriceForCurrency(@Param("product_id") Long productID, @Param("currency") String currency);
}
