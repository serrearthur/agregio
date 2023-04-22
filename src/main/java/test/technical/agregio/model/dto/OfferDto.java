package test.technical.agregio.model.dto;

import java.math.BigDecimal;
import java.util.Map;

public record OfferDto(long id, String reference, Map<TimeBlockDto, ProviderDto> contract, BigDecimal totalCost) {
}
