package nl.scholtens.material.controller;

import nl.scholtens.material.SessionBuilder;
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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ListsControllerTest  extends TreinMaterieelApplicationTest  {

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
    public void getLocLijstTest() throws Exception {
        Mockito.when(locService.getLocList(Mockito.anyString())).thenReturn(new ArrayList<Locomotive>());

        mockMvc.perform(get("/locs")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("loclistView"));
    }

    @Test
    public void getCarListTest() throws Exception {
        Mockito.when(carService.getCarList(Mockito.anyString())).thenReturn(new ArrayList<Waggon>());

        mockMvc.perform(get("/cars")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("carlistView"));
    }

    @Test
    public void getOperatorsListTest() throws Exception {
        Mockito.when(operatorService.getOperatorList(Mockito.anyString())).thenReturn(new ArrayList<OperatorTrain>());

        mockMvc.perform(get("/operators")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("operatorListView"));
    }

}
