package test.technical.agregio.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import test.technical.agregio.model.EnergyType;
import test.technical.agregio.model.dto.ProviderCreationDto;
import test.technical.agregio.model.dto.ProviderDto;
import test.technical.agregio.rest.exception.ResourceNotFoundException;
import test.technical.agregio.service.ProviderService;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProviderControllerTest {

    @Mock
    private ProviderService providerService;

    @InjectMocks
    private ProviderController providerController;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(providerController).build();
    }

    @Test
    void getProvider_shouldReturnExisting() throws Exception {
        long targetId = 1L;
        ProviderDto expectedResult = new ProviderDto(targetId, "test", EnergyType.AEOLIAN, null);
        when(providerService.getProviderDtoById(targetId)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/provider/" + targetId))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    void getProvider_shouldThrowResourceNotFound() throws Exception {
        long targetId = 1L;
        when(providerService.getProviderDtoById(targetId)).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/provider/" + targetId))
                .andExpect(MockMvcResultMatchers.status().is(404));
    }

    @Test
    void createProvider_shouldCreate() throws Exception {
        long targetId = 1L;
        ProviderCreationDto creationDto = new ProviderCreationDto("test", EnergyType.AEOLIAN);
        when(providerService.createProvider(creationDto)).thenReturn(targetId);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/provider")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(creationDto))
                )
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(targetId)));
    }

    @Test
    void createProvider_shouldThrowValidationException() throws Exception {
        ProviderCreationDto creationDto = new ProviderCreationDto(null, null);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/provider")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(creationDto))
                )
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}