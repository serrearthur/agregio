package test.technical.agregio.model.dto;

import java.math.BigDecimal;

public record ProductionDto(long id, BigDecimal value, TimeBlockDto timeBlock) {
}
