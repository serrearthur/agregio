package test.technical.agregio.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.technical.agregio.model.dto.ProviderCreationDto;
import test.technical.agregio.model.dto.ProviderDto;
import test.technical.agregio.service.ProviderService;

@Validated
@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderService providerService;

    ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProviderDto getProvider(@PathVariable Long id) {
        return providerService.getProviderDtoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createProvider(@RequestBody @Valid ProviderCreationDto dto) {
        return providerService.createProvider(dto);
    }
}
