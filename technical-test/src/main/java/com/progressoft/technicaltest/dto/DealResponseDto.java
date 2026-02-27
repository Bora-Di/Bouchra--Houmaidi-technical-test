package com.progressoft.technicaltest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

public record DealResponseDto(
        @NotBlank(message = "Deal ID must not be blank")
        String id,

        @NotNull(message = "From currency must be provided")
        Currency fromCurrency,

        @NotNull(message = "To currency must be provided")
        Currency toCurrency,

        @NotNull(message = "Timestamp must be provided")
        LocalDateTime timestamp,

        @NotNull(message = "Amount must be provided")
        @Positive(message = "Amount must be positive")
        BigDecimal amount
) {
}