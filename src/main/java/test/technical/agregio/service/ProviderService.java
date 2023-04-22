package test.technical.agregio.service;

import org.springframework.stereotype.Service;
import test.technical.agregio.dao.ProviderDao;
import test.technical.agregio.model.Provider;
import test.technical.agregio.model.dto.ProviderCreationDto;
import test.technical.agregio.model.dto.ProviderDto;
import test.technical.agregio.model.mapper.ProviderMapper;
import test.technical.agregio.rest.exception.ResourceNotFoundException;

@Service
public class ProviderService {

    private final ProviderDao providerDao;
    private final ProviderMapper providerMapper;

    ProviderService(
            ProviderDao providerDao,
            ProviderMapper providerMapper
    ) {
        this.providerDao = providerDao;
        this.providerMapper = providerMapper;
    }

    public Long createProvider(ProviderCreationDto dto) {
        Provider entity = providerMapper.creationDtoToProvider(dto);
        return providerDao.save(entity).getId();
    }

    public ProviderDto getProviderDtoById(Long id) {
        return providerMapper.providerToProviderDto(getProviderById(id));
    }

    protected Provider getProviderById(Long id) {
        return providerDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Provider with id " + id + " not found"));
    }
}
