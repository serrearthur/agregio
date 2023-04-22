package test.technical.agregio.model.dto;

import java.time.OffsetTime;

public record TimeBlockDto(OffsetTime startTime, OffsetTime endTime) {
}
