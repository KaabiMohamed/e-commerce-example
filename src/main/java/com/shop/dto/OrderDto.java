package com.shop.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Represents a Data Transfer Object (DTO) for an order.
 */
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto extends AbstractOrderDto {

    /**
     * The ID of the order.
     */
    private Long id;

    /**
     * The list of order entries associated with this order.
     */
    private List<OrderEntryDto> entries;

}
