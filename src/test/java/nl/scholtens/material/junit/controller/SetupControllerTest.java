package nl.scholtens.material.junit.controller;

import nl.scholtens.material.junit.TreinMaterieelApplicationTest;
import nl.scholtens.material.formobject.SessionForm;
import nl.scholtens.material.service.SetupService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class SetupControllerTest extends TreinMaterieelApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private SetupService setupService;

    @Mock
    private SessionForm sessionForm;

    private MockMvc mockMvc;

    @Mock
    private MockHttpServletRequest request;
    @Mock
    private MockHttpSession session;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        request = new MockHttpServletRequest();
        session = new MockHttpSession();
        session.setAttribute("sessionform", new SessionForm());
    }

    @Test
    public void instellingIniFileFiledTest() throws Exception {
        String paths[] = {"1", "2"};
        Mockito.when(setupService.readSetupFile()).thenReturn(paths);
        mockMvc.perform(get("/setup"))
                .andExpect(model().attribute("gevuld", false))
                .andExpect(status().isOk())
                .andExpect(view().name("setupView"));
    }

    @Test
    public void instellingIniFileEmptyTest() throws Exception {
        Mockito.when(setupService.isFileEmpty()).thenReturn(true);
        mockMvc.perform(get("/setup"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("gevuld", false))
                .andExpect(model().attribute("xmlpath", "pad en bestand niet gevuld"))
                .andExpect(model().attribute("imagepath", "pad niet gevuld"))
                .andExpect(view().name("setupView"));
    }

    @Test
    public void writeSetupInputFielsEmptyTest() throws Exception {
        String paths[] = {"1", "2"};
        Mockito.when(setupService.readSetupFile()).thenReturn(paths);
        mockMvc.perform(post("/setup"))
                .andExpect(status().isOk())
                .andExpect(view().name("setupView"));
    }

    @Test
    public void writeSetupInputFielsFiledTest() throws Exception {
        String paths[] = {"1", "2"};
        Mockito.when(setupService.readSetupFile()).thenReturn(paths);
        Mockito.when(setupService.isFileEmpty()).thenReturn(false);

        Mockito.doNothing().when(setupService).writeSetupFile(Mockito.anyString() ,Mockito.anyString());

        mockMvc.perform(post("/setup")
                .param("padxml", "1")
                .param("padafbeelding", "2")
                .param("terug", "true"))
                .andExpect(status().isOk())
                .andExpect(view().name("setupView"));
    }


    @Test
    public void viewsTest() throws Exception {
        mockMvc.perform(post("/keuze")
                .param("loc", "loc"))
                .andExpect(redirectedUrl("/locs"));

        mockMvc.perform(post("/keuze")
                .param("car", "car"))
                .andExpect(redirectedUrl("/cars"));

        mockMvc.perform(post("/keuze")
                .param("train", "train"))
                .andExpect(redirectedUrl("/operators"));
    }

    @Test
    public void searchMethodesTest() throws Exception {
        mockMvc.perform(get("/zoeken"))
                .andExpect(status().isOk())
                .andExpect(view().name("forward:/material"));

        mockMvc.perform(get("/zoeken")
                .param("br", "br"))
                .andExpect(status().isOk())
                .andExpect(view().name("forward:/zoek/br"));

        mockMvc.perform(get("/zoeken")
                .param("owner", "owner"))
                .andExpect(status().isOk())
                .andExpect(view().name("forward:/zoek/owner"));

        mockMvc.perform(get("/zoeken")
                .param("catalog", "catalog"))
                .andExpect(status().isOk())
                .andExpect(view().name("forward:/zoek/catalog"));


    }

}
