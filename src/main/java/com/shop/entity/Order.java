package com.shop.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * Represents an order with multiple order entries.
 */
@Entity
@Table(name = "orders")
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends AbstractOrder {

    /**
     * The list of order entries associated with the order.
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderEntry> entries;

    /**
     * Checks if the order is empty (i.e., contains no order entries).
     *
     * @return true if the order is empty, false otherwise.
     */
    public boolean isEmpty() {
        return entries.isEmpty();
    }
}
