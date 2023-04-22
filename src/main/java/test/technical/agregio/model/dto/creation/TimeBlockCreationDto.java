package test.technical.agregio.model.dto.creation;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetTime;

public record TimeBlockCreationDto(
        @NotNull(message = "startTime can't be null") OffsetTime startTime,
        @NotNull(message = "endTime can't be null") OffsetTime endTime) {
}
