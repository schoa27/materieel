package nl.scholtens.material.controller;

import nl.scholtens.material.TreinMaterieelApplicationTest;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.formobject.SessionForm;
import nl.scholtens.material.service.LocService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



public class DetailsControllerTest extends TreinMaterieelApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private LocService locService;

    private MockMvc mockMvc;

    private Locomotive locomotive;



    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        request().sessionAttribute("sessionform", new SessionForm());
          }

    @Test
    public void testGetLocDetails() throws Exception {
        Mockito.when(locService.getLocById(Mockito.anyString(), Mockito.anyString())).thenReturn(new Locomotive());



//        mockMvc.perform(get("/loc-0"))
//
//                               .andExpect(status().isOk())
//
//        ;

    }


}