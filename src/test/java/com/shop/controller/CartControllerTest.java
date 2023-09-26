package com.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.dto.CartDto;
import com.shop.dto.request.AddToCartRequest;
import com.shop.entity.Product;
import com.shop.facade.CartFacade;
import com.shop.facade.OrderFacade;
import com.shop.repository.CurrencyRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.service.CartService;
import com.shop.service.OrderService;
import com.shop.service.ProductService;
import com.shop.service.SessionService;
import com.shop.strategy.CalculationStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class CartControllerTest {
    @Autowired MockMvc mockMvc;
    @MockBean
    SessionService sessionService;
    @MockBean
    OrderFacade orderFacade;
    @MockBean
    OrderService orderService;
    @MockBean
    CartService cartService;
    @MockBean
    CartFacade cartFacade;
    @MockBean
    ProductService productService;
    @MockBean
    CalculationStrategy calculationStrategy;

    @MockBean
    ProductRepository productRepository;
    @MockBean
    OrderRepository orderRepository;


    @Test
    @DisplayName("Test call to add to cart")
    public void testAddToCart() throws Exception {
        Mockito.when(cartFacade.addToCart(1L,1)).thenReturn(new CartDto(new ArrayList<>()));
        Mockito.when(productService.getProductForId(anyLong())).thenReturn(new Product());
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/cart/add-to-cart")
                        .content(asJsonString(new AddToCartRequest(1L,1)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.entries").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
