package test.technical.agregio.model.dto.creation;

import jakarta.validation.constraints.NotNull;

public record OfferCreationDto(@NotNull(message = "Reference can't be null") String reference) {
}
