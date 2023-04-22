package test.technical.agregio.model.dto.creation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import test.technical.agregio.model.EnergyType;

public record ProviderCreationDto(
        @NotBlank(message = "Name must not be empty") String name,
        @NotNull(message = "EnergyType must be valid") EnergyType energyType
) {
}
