package test.technical.agregio.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import test.technical.agregio.model.dto.ProductionDto;
import test.technical.agregio.model.dto.TimeBlockDto;
import test.technical.agregio.model.dto.creation.ProductionCreationDto;
import test.technical.agregio.model.dto.creation.TimeBlockCreationDto;
import test.technical.agregio.rest.exception.ResourceNotFoundException;
import test.technical.agregio.service.ProductionService;

import java.math.BigDecimal;
import java.time.OffsetTime;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductionControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Mock
    private ProductionService productionService;
    @InjectMocks
    private ProductionController productionController;
    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        objectMapper.registerModule(new JavaTimeModule());
        mockMvc = MockMvcBuilders.standaloneSetup(productionController).build();
    }

    @Test
    void getProduction_shouldReturnOne() throws Exception {
        long providerId = 1L;
        long productionId = 1L;
        ProductionDto expectedResult = new ProductionDto(1L, BigDecimal.TEN, BigDecimal.TEN, new TimeBlockDto(null, null));
        when(productionService.getProductionDto(providerId, productionId)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/provider/" + providerId + "/production/" + productionId))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    void getAllProduction_shouldReturnAll() throws Exception {
        long providerId = 1L;
        Set<ProductionDto> expectedResult = Set.of(
                new ProductionDto(1L, BigDecimal.TEN, BigDecimal.TEN, new TimeBlockDto(null, null)),
                new ProductionDto(2L, BigDecimal.ONE, BigDecimal.ONE, new TimeBlockDto(null, null))
        );

        when(productionService.getAllProductionDto(providerId)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/provider/" + providerId + "/production/"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    void getProduction_shouldThrowResourceNotFoundException() throws Exception {
        when(productionService.getProductionDto(anyLong(), anyLong())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/provider/1/production/1"))
                .andExpect(MockMvcResultMatchers.status().is(404));
    }

    @Test
    void createProduction_shouldCreate() throws Exception {
        long targetId = 1L;
        ProductionCreationDto creationDto = new ProductionCreationDto(
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                new TimeBlockCreationDto(OffsetTime.now(), OffsetTime.now())
        );

        when(productionService.createProduction(targetId, creationDto)).thenReturn(targetId);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/provider/" + targetId + "/production")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(creationDto))
                )
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(targetId)));
    }

    @Test
    void createProduction_shouldThrowValidationException() throws Exception {
        ProductionCreationDto creationDto = new ProductionCreationDto(null, null, null);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/provider/1/production")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(creationDto))
                )
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}