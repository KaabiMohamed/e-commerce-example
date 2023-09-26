package com.shop.strategy;

import com.shop.entity.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This interface defines a calculation strategy for order-related operations.
 */
public interface CalculationStrategy {

    /**
     * The value used for rounding tax calculations to the nearest 0.05.
     */
    double NEAREST = 0.05;

    /**
     * Recalculates the values of an abstract order.
     *
     * @param order The abstract order to be recalculated.
     */
    void recalculate(AbstractOrder order);

    /**
     * Recalculates the values of an abstract order entry.
     *
     * @param entry The abstract order entry to be recalculated.
     */
    void recalculateOrderEntry(AbstractOrderEntry entry);

    /**
     * Calculates the tax amount based on a given price before tax and tax rate.
     *
     * @param priceHT  The price before tax.
     * @param taxRate  The tax rate as a percentage.
     * @return         The calculated tax amount.
     */
    default BigDecimal calculateTax(BigDecimal priceHT, BigDecimal taxRate) {
        // Calculate the raw sales tax
        BigDecimal rawTax = priceHT.multiply(taxRate).divide(BigDecimal.valueOf(100));
        int scale = 0;
        RoundingMode roundingMode = RoundingMode.CEILING;
        // Round the raw tax up to the nearest 0.05
        return rawTax.divide(BigDecimal.valueOf(NEAREST), scale, roundingMode).multiply(BigDecimal.valueOf(NEAREST));
    }

}
