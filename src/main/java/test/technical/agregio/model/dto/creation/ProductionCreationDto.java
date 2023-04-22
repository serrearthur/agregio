package test.technical.agregio.model.dto.creation;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductionCreationDto(
        @NotNull(message = "amountProduced can't be null") BigDecimal amountProduced,
        @NotNull(message = "minimalRetailValue can't be null") BigDecimal minimalRetailValue,
        @NotNull(message = "timeBlock can't be null") TimeBlockCreationDto timeBlock
) {
}
