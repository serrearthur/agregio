package test.technical.agregio.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.technical.agregio.model.dto.OfferDto;
import test.technical.agregio.model.dto.creation.OfferCreationDto;
import test.technical.agregio.service.OfferService;

@Validated
@RestController
@RequiredArgsConstructor //needed for constructor dependency injection
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;

    @GetMapping(path = "/{id}")
    OfferDto getOffer(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Long createOffer(@RequestBody @Valid OfferCreationDto dto) {
        return null;
    }
}
