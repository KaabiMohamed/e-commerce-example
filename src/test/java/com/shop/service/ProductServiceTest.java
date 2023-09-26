package com.shop.service;

import com.shop.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("Test Get Product For ID")
    void testGetProductForID(){
        //GIVEN
        Long productID = 1L;
        String productName = "book";
        //WHEN
        Product product = productService.getProductForId(productID);
        //THEN
        assertNotNull(product);
        assertEquals(productName,product.getName());

    }

    @Test
    @DisplayName("Test Not Found Product For ID")
    void testNotFoundProductForID(){
        //GIVEN
        Long productID = 100L;
        //THEN
        assertThrows(ResourceNotFoundException.class, () -> {
            productService.getProductForId(productID);
        });
    }

    @Test
    @DisplayName("Test Calculate Product HT Price For Currency in session")
    void calculateProductHTPrice(){
        //GIVEN
        Long productID = 1L;
        double price = 12.49;
        //WHEN
        Product product = productService.getProductForId(productID);
        BigDecimal calculatedPrice = productService.getPrice(product);
        assertEquals(price,calculatedPrice.doubleValue());
    }
    @Test
    @DisplayName("Test Calculate Tax Rate For Exempted Product")
    void calculateTaxRateForExemptedProduct(){
        //GIVEN
        Long productID = 1L;
        //WHEN
        Product product = productService.getProductForId(productID);
        BigDecimal vatRate = productService.getTaxRate(product);
        assertEquals(0,vatRate.doubleValue());
    }

    @Test
    @DisplayName("Test Calculate Tax Rate For Basic Tax")
    void calculateTaxRateForBasicTax(){
        //GIVEN
        Long productID = 2L;
        //WHEN
        Product product = productService.getProductForId(productID);
        BigDecimal vatRate = productService.getTaxRate(product);
        assertEquals(10.0,vatRate.doubleValue() );
    }

    @Test
    @DisplayName("Test Calculate Tax Rate For Imported Basic Tax")
    void calculateTaxRateForImportedBasicTax(){
        //GIVEN
        Long productID = 5L;
        //WHEN
        Product product = productService.getProductForId(productID);
        BigDecimal vatRate = productService.getTaxRate(product);
        assertEquals(15.0,vatRate.doubleValue() );
    }


}
