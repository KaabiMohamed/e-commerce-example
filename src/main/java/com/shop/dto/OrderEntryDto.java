package com.shop.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Represents a Data Transfer Object (DTO) for an order entry.
 */
@ToString
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntryDto extends AbstractOrderEntryDto {

    /**
     * The ID of the order entry.
     */
    private Long id;
}
