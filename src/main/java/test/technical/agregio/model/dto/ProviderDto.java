package test.technical.agregio.model.dto;

import test.technical.agregio.model.EnergyType;

import java.util.Set;

public record ProviderDto(long id, String name, EnergyType energyType, Set<ProductionDto> production) {
}
