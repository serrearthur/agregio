package test.technical.agregio.model.mapper;

import org.mapstruct.Mapper;
import test.technical.agregio.model.Provider;
import test.technical.agregio.model.dto.ProviderCreationDto;
import test.technical.agregio.model.dto.ProviderDto;

@Mapper(config = CommonMapperConfig.class)
public interface ProviderMapper {
    Provider creationDtoToProvider(ProviderCreationDto creationDto);
    ProviderDto providerToProviderDto(Provider provider);
}
