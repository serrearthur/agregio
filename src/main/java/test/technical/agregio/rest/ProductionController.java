package test.technical.agregio.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.technical.agregio.model.dto.ProductionDto;
import test.technical.agregio.model.dto.creation.ProductionCreationDto;
import test.technical.agregio.service.ProductionService;

import java.util.Set;

@Validated
@RestController
@RequiredArgsConstructor //needed for constructor dependency injection
@RequestMapping("/provider/{providerId}/production")
public class ProductionController {

    private final ProductionService productionService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductionDto getProduction(@PathVariable Long providerId, @PathVariable Long id) {
        return productionService.getProductionDto(providerId, id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<ProductionDto> getAllProduction(@PathVariable Long providerId) {
        return productionService.getAllProductionDto(providerId);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createProvider(@PathVariable Long providerId, @RequestBody @Valid ProductionCreationDto dto) {
        return productionService.createProduction(providerId, dto);
    }
}
