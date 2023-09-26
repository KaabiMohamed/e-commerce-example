package com.shop.dto.response;

import lombok.*;

/**
 * A data transfer object (DTO) representing an error response.
 * It contains information about an error, including a code, message, and details.
 */
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    /**
     * The error code indicating the type of error.
     */
    private String code;

    /**
     * A human-readable error message describing the error.
     */
    private String message;

    /**
     * Additional details or context information about the error.
     */
    private String details;
}