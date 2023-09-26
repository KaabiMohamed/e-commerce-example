package com.shop.controller;

import com.shop.facade.OrderFacade;
import com.shop.facade.impl.OrderFacadeImpl;
import com.shop.repository.CurrencyRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.service.CartService;
import com.shop.service.OrderService;
import com.shop.service.ProductService;
import com.shop.service.SessionService;
import com.shop.service.impl.CartServiceImpl;
import com.shop.service.impl.OrderServiceImpl;
import com.shop.service.impl.ProductServiceImpl;
import com.shop.service.impl.SessionServiceImpl;
import com.shop.strategy.CalculationStrategy;
import com.shop.strategy.CartCalculationStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
@ActiveProfiles("test")
@Import({CartCalculationStrategy.class,SessionServiceImpl.class, OrderFacadeImpl.class,
        OrderServiceImpl.class, CartServiceImpl.class, ProductServiceImpl.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
class OrderControllerTest {
    @Autowired MockMvc mockMvc;
    @Autowired SessionService sessionService;
    @Autowired OrderFacade orderFacade;
    @Autowired OrderService orderService;
    @Autowired CartService cartService;
    @Autowired ProductService productService;
    @Autowired CalculationStrategy calculationStrategy;
    @MockBean CurrencyRepository currencyRepository;
    @MockBean ProductRepository productRepository;
    @MockBean OrderRepository orderRepository;


    @Test
    @DisplayName("place empty order is a bad request")
    void testAddToCart() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/order/place-order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
