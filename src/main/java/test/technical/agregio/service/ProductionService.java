package test.technical.agregio.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.technical.agregio.dao.ProductionDao;
import test.technical.agregio.model.Production;
import test.technical.agregio.model.Provider;
import test.technical.agregio.model.TimeBlock;
import test.technical.agregio.model.dto.ProductionDto;
import test.technical.agregio.model.dto.creation.ProductionCreationDto;
import test.technical.agregio.model.mapper.ProductionMapper;
import test.technical.agregio.rest.exception.ResourceNotFoundException;

import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor //needed for constructor dependency injection
public class ProductionService {

    private final ProductionDao productionDao;
    private final ProductionMapper productionMapper;

    private final ProviderService providerService;
    private final TimeBlockService timeBlockService;

    public ProductionDto getProductionDto(Long providerId, Long productionId) {
        Production result = productionDao.findByProvider_IdAndId(providerId, productionId).orElseThrow(
                () -> new ResourceNotFoundException("Production with id " + productionId + " not found for provider " + providerId)
        );
        return productionMapper.productionToProductionDto(result);
    }

    public Set<ProductionDto> getAllProductionDto(Long providerId) {
        Set<Production> result = productionDao.findAllByProvider_Id(providerId);
        return productionMapper.listDtoFromListProduction(result);
    }

    public Long createProduction(Long providerId, ProductionCreationDto dto) {
        Provider provider = providerService.getProviderById(providerId);
        TimeBlock timeBlock = timeBlockService.createTimeBlock(dto.timeBlock());

        Production entity = productionMapper.creationDtoToProduction(dto);
        entity.setProvider(provider);
        entity.setTimeBlock(timeBlock);

        return productionDao.save(entity).getId();
    }
}
