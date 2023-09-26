package com.shop.controller;

import com.shop.dto.OrderDto;
import com.shop.dto.response.ErrorResponse;
import com.shop.facade.OrderFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Tag(name = "Order Controller", description = "API endpoints for managing orders")
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    /**
     * Places a new order.
     *
     * @return The order DTO representing the placed order.
     */
    @PostMapping("/place-order")
    @Operation(summary = "Place a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order placed successfully",useReturnTypeSchema = true),
            @ApiResponse(responseCode = "400", description = "Empty Cart", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    public OrderDto placeOrder() {
        return orderFacade.placeOrder();
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param orderID The ID of the order to retrieve.
     * @return The order DTO representing the retrieved order.
     */
    @GetMapping("/{orderID}")
    @Operation(summary = "Get an order by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order retrieved successfully",useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", description = "Order not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    public OrderDto getOrder(
            @Parameter(description = "The ID of the order to retrieve", required = true)
            @PathVariable("orderID") Long orderID) {
        return orderFacade.getOrderForID(orderID);
    }
}
