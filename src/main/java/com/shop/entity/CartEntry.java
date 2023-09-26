package com.shop.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Represents a cart entry with product, quantity, and pricing details.
 */
@Entity
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartEntry extends AbstractOrderEntry implements Serializable {

    /**
     * The cart to which this entry belongs.
     */
    @ManyToOne
    private Cart cart;
}
