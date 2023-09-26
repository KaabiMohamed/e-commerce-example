package com.shop.strategy;

import com.shop.entity.*;
import com.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * This class represents a strategy for calculating the values of a shopping cart.
 */
@Service
@Qualifier("cartCalculationService")
@Slf4j
public class CartCalculationStrategy implements CalculationStrategy {

    @Autowired
    ProductService productService;

    /**
     * Recalculates the values of a shopping cart, including total price before tax (priceHT),
     * total tax (vat), and total price after tax (netPrice).
     *
     * @param order The shopping cart to be recalculated.
     */
    @Override
    public void recalculate(AbstractOrder order) {
        Cart cart = (Cart) order;
        cart.getEntries().forEach(this::recalculateOrderEntry);
        BigDecimal totalHT = cart.getEntries().stream()
                .map(CartEntry::getPriceHT) // Extract priceHT from each entry
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalTax = cart.getEntries().stream()
                .map(CartEntry::getVat) // Extract VAT from each entry
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalNet = cart.getEntries().stream()
                .map(CartEntry::getNetPrice) // Extract netPrice from each entry
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setVat(totalTax);
        cart.setPriceHT(totalHT);
        cart.setNetPrice(totalNet);
        cart.setCalculated(true);
    }

    /**
     * Recalculates the values of an order entry, including price before tax (priceHT),
     * tax rate (vatRate), total tax (vat), and price after tax (netPrice).
     *
     * @param entry The order entry to be recalculated.
     */
    @Override
    public void recalculateOrderEntry(AbstractOrderEntry entry) {
        Product product = entry.getProduct();
        BigDecimal productUnitPrice = productService.getPrice(product);
        BigDecimal productTaxRate = productService.getTaxRate(product);
        int quantity = entry.getQuantity();
        BigDecimal totalPriceHT = productUnitPrice.multiply(BigDecimal.valueOf(quantity));
        BigDecimal totalTax = calculateTax(totalPriceHT, productTaxRate);
        entry.setQuantity(quantity);
        entry.setPriceHT(totalPriceHT);
        entry.setVatRate(productTaxRate);
        entry.setVat(totalTax);
        entry.setNetPrice(totalPriceHT.add(totalTax));
    }

}
