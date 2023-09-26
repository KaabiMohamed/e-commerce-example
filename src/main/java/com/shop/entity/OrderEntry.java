package com.shop.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * Represents an entry in an order with product, quantity, and pricing details.
 */
@Entity
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntry extends AbstractOrderEntry {

    @ManyToOne
    private Order order;
}
