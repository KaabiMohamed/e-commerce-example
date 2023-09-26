package com.shop.repository;

import com.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This repository provides access to order data in a shopping application.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
