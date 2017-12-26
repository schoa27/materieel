package nl.scholtens.material.junit.controller;

import nl.scholtens.material.junit.TreinMaterieelApplicationTest;
import nl.scholtens.material.domain.Locomotive;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class SlavesControllerTest extends TreinMaterieelApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private LocService locService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getSlaveLocsTest() throws Exception {
        Mockito.when(locService.getSlaveLocs(Mockito.anyString(), Mockito.anyString())).thenReturn(new Locomotive());

        mockMvc.perform(get("/slaves/loc-0"))
                .andExpect(status().isOk())
                .andExpect(view().name("tractionDetails"));
    }

}
