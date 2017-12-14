package nl.scholtens.material.controller;

import nl.scholtens.material.TreinMaterieelApplicationTest;
import nl.scholtens.material.domain.OperatorTrain;
import nl.scholtens.material.service.OperatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class OperatorControllerTest extends TreinMaterieelApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private OperatorService operatorService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getOperatorDetailsTest() throws Exception {
        Mockito.when(operatorService.getOpertorByLocId(Mockito.anyString(), Mockito.anyString())).thenReturn(new OperatorTrain());

        mockMvc.perform(get("/operator/loc-1"))
                .andExpect(status().isOk())
                .andExpect(view().name("OperatorView"));
    }
}
