package test.technical.agregio.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.technical.agregio.dao.ProviderDao;
import test.technical.agregio.model.Provider;
import test.technical.agregio.model.dto.ProviderDto;
import test.technical.agregio.model.dto.creation.ProviderCreationDto;
import test.technical.agregio.model.mapper.ProviderMapper;
import test.technical.agregio.rest.exception.ResourceNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor //needed for constructor dependency injection
public class ProviderService {

    private final ProviderDao providerDao;
    private final ProviderMapper providerMapper;

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
