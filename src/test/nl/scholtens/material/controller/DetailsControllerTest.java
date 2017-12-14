package nl.scholtens.material.controller;

import nl.scholtens.material.TreinMaterieelApplicationTest;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.OperatorTrain;
import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.formobject.SessionForm;
import nl.scholtens.material.service.CarService;
import nl.scholtens.material.service.LocService;
import nl.scholtens.material.service.OperatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import javax.servlet.http.HttpServletRequest;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class DetailsControllerTest extends TreinMaterieelApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private LocService locService;

    @MockBean
    private CarService carService;

    @MockBean
    private OperatorService operatorService;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        session = new MockHttpSession();
        session.setAttribute("sessionform", creatSessionForm());
    }

    @Test
    public void detailsLocTest() throws Exception {
        Mockito.when(locService.getLocById(Mockito.anyString(), Mockito.anyString())).thenReturn(new Locomotive());

        mockMvc.perform(get("/loc-0")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(model().attribute("id", "loc"))
                .andExpect(view().name("locDetails"));
    }

    @Test
    public void detailsCarTest() throws Exception {
        Mockito.when(carService.getCarById(Mockito.anyString(), Mockito.anyString())).thenReturn(new Waggon());

        mockMvc.perform(get("/car-0")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(model().attribute("id", "car"))
                .andExpect(view().name("carDetails"));
    }

    @Test
    public void detailsOperatorTest() throws Exception {
        Mockito.when(operatorService.getOperatorById(Mockito.anyString(), Mockito.anyString())).thenReturn(new OperatorTrain());

        mockMvc.perform(get("/opr-0")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(model().attribute("id", "loc"))
                .andExpect(view().name("operatorDetails"));
    }


    private SessionForm creatSessionForm() {
        SessionForm sessionForm = new SessionForm();
        sessionForm.setDate(new Date().toString());
        return sessionForm;
    }
}
