package test.technical.agregio.model.mapper;

import org.mapstruct.Mapper;
import test.technical.agregio.model.TimeBlock;
import test.technical.agregio.model.dto.creation.TimeBlockCreationDto;

@Mapper(config = CommonMapperConfig.class)
public interface TimeBlockMapper {
    TimeBlock creationDtoToTimeBlock(TimeBlockCreationDto dto);
}
