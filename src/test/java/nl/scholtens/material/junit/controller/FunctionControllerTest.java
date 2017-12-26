package nl.scholtens.material.junit.controller;

import nl.scholtens.material.junit.TreinMaterieelApplicationTest;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.service.CarService;
import nl.scholtens.material.service.LocService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class FunctionControllerTest extends TreinMaterieelApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private LocService locService;

    @MockBean
    private CarService carService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getFunctionsLocTest() throws Exception {
        Mockito.when(locService.getLocById(Mockito.anyString(), Mockito.anyString())).thenReturn(new Locomotive());

        mockMvc.perform(get("/function/loc-0"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("id", "loc"))
                .andExpect(view().name("functionlistView"));
    }

    @Test
    public void getFunctionsCarTest() throws Exception {
        Mockito.when(carService.getCarById(Mockito.anyString(), Mockito.anyString())).thenReturn(new Waggon());

        mockMvc.perform(get("/function/car-0"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("id", "car"))
                .andExpect(view().name("functionlistView"));
    }

}
