package com.shop.controller;

import com.shop.dto.CartDto;
import com.shop.dto.request.AddToCartRequest;
import com.shop.dto.response.ErrorResponse;
import com.shop.facade.CartFacade;
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
@RequestMapping("/cart")
@Tag(name = "Cart Controller", description = "API endpoints for managing the shopping cart")
public class CartController {

    @Autowired
    private CartFacade cartFacade;

    /**
     * Adds a product to the shopping cart.
     *
     * @param addToCartRequest The request containing product details to add.
     * @return The updated cart DTO.
     */
    @PostMapping("/add-to-cart")
    @Operation(summary = "Add a product to the shopping cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product added to cart successfully",useReturnTypeSchema = true),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    public CartDto addToCart(
            @Parameter(description = "Request containing product details to add", required = true)
            @RequestBody AddToCartRequest addToCartRequest) {
        return cartFacade.addToCart(addToCartRequest.getProductID(), addToCartRequest.getQuantity());
    }

    /**
     * Clears the shopping cart.
     */
    @PostMapping("/clear")
    @Operation(summary = "Clear the shopping cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shopping cart cleared successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    public void clearCart() {
        cartFacade.clearCart();
    }
}
