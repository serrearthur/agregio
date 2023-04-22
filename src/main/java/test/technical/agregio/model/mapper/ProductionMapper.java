package test.technical.agregio.model.mapper;

import org.mapstruct.Mapper;
import test.technical.agregio.model.Production;
import test.technical.agregio.model.dto.ProductionDto;
import test.technical.agregio.model.dto.creation.ProductionCreationDto;

import java.util.Set;

@Mapper(config = CommonMapperConfig.class)
public interface ProductionMapper {
    Production creationDtoToProduction(ProductionCreationDto creationDto);

    Set<ProductionDto> listDtoFromListProduction(Set<Production> productions);

    ProductionDto productionToProductionDto(Production production);
}
