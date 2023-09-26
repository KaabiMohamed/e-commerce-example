package com.shop.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Represents a Data Transfer Object (DTO) for a shopping cart entry.
 */
@ToString
@SuperBuilder
@Getter
@Setter
public class CartEntryDto extends AbstractOrderEntryDto {
}
