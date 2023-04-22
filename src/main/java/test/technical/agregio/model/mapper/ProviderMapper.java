package test.technical.agregio.model.mapper;

import org.mapstruct.Mapper;
import test.technical.agregio.model.Provider;
import test.technical.agregio.model.dto.ProviderDto;
import test.technical.agregio.model.dto.creation.ProviderCreationDto;

@Mapper(config = CommonMapperConfig.class)
public interface ProviderMapper {
    Provider creationDtoToProvider(ProviderCreationDto creationDto);

    ProviderDto providerToProviderDto(Provider provider);
}
