package com.shop.service.impl;

import com.shop.entity.Product;
import com.shop.entity.TaxGroup;
import com.shop.repository.ProductRepository;
import com.shop.service.ProductService;
import com.shop.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * This class provides product-related services in a shopping application.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SessionService sessionService;

    /**
     * Retrieves a product based on its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return   The product corresponding to the given ID.
     * @throws   ResourceNotFoundException if the product is not found.
     */
    @Override
    public Product getProductForId(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent())
            throw new ResourceNotFoundException(String.format("Could not find product %s", id));
        return product.get();
    }

    /**
     * Retrieves the price of a product in the session's currency.
     *
     * @param p The product for which the price is to be retrieved.
     * @return  The price of the product as a BigDecimal.
     */
    @Override
    public BigDecimal getPrice(Product p) {
        return getPriceForCurrency(p, sessionService.getSessionCurrency());
    }

    /**
     * Retrieves the price of a product in the specified currency.
     *
     * @param p        The product for which the price is to be retrieved.
     * @param currency The currency in which the price should be expressed.
     * @return         The price of the product in the specified currency as a BigDecimal.
     */
    @Override
    public BigDecimal getPriceForCurrency(Product p, String currency) {
        return productRepository.getHTPriceForCurrency(p.getId(), currency);
    }

    /**
     * Retrieves the tax rate for a product.
     *
     * @param p The product for which the tax rate is to be retrieved.
     * @return  The tax rate for the product as a BigDecimal.
     * @throws  ResourceNotFoundException if the product does not have a tax group.
     */
    @Override
    public BigDecimal getTaxRate(Product p) {
        TaxGroup taxGroup = p.getTax();
        if (taxGroup == null) {
            throw new ResourceNotFoundException(String.format("Product %s does not have a tax group", p.getId()));
        }
        BigDecimal tax = taxGroup.getTaxRate().getTaxRate();

        if (taxGroup.getAdditionalTax() != null && taxGroup.getAdditionalTax().getTaxRate() != null)
            tax = tax.add(taxGroup.getAdditionalTax().getTaxRate());

        return tax;
    }
}
