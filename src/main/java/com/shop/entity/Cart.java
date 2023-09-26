package com.shop.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Represents a shopping cart with multiple cart entries.
 */
@Entity
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends AbstractOrder implements Serializable {

    /**
     * Indicates whether the cart has been calculated.
     */
    private boolean isCalculated;

    /**
     * The list of cart entries associated with the cart.
     */
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartEntry> entries;
}
