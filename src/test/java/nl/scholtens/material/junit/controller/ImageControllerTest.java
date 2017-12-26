package nl.scholtens.material.junit.controller;

import nl.scholtens.material.junit.TreinMaterieelApplicationTest;
import nl.scholtens.material.service.SetupService;
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

public class ImageControllerTest extends TreinMaterieelApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private SetupService setupService;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * this method needs a file named testbestand.png wich is in the root of the project.
     * @throws Exception
     */

    @Test
    public void getImageTest() throws Exception {
        byte[] bytes = null;
        String paths[] = {"1", "test"};
        Mockito.when(setupService.readSetupFile()).thenReturn(paths);

        mockMvc.perform(get("/image/bestand"))
                .andExpect(status().isOk());

    }
}
