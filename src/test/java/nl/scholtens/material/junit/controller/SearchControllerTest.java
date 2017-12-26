package nl.scholtens.material.junit.controller;

import nl.scholtens.material.junit.TreinMaterieelApplicationTest;
import nl.scholtens.material.junit.builders.CarListBuilder;
import nl.scholtens.material.junit.builders.LocListBuilder;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.service.SearchService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SearchControllerTest extends TreinMaterieelApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private SearchService searchService;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        session = new MockHttpSession();
        session.setAttribute("sessionform", creatSessionForm());
    }

    @Test
    public void searchOwnerTestLocCar() throws Exception {
        Map<String, List<?>> searchResults = createSearchResults();
        Mockito.when(searchService.searchOwner(Mockito.anyString(), Mockito.anyString())).thenReturn(searchResults);

        mockMvc.perform(get("/zoek/owner")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchOwnerTestEmptyLists() throws Exception {
        Mockito.when(searchService.searchOwner(Mockito.anyString(), Mockito.anyString())).thenReturn(createEmptySearchResults());

        mockMvc.perform(get("/zoek/owner")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchOwnerTestLoc() throws Exception {
        Map<String, List<?>> searchResults = createEmptySearchResults();
        searchResults.remove("car");

        Mockito.when(searchService.searchOwner(Mockito.anyString(), Mockito.anyString())).thenReturn(searchResults);

        mockMvc.perform(get("/zoek/owner")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchCatalogTestLocCar() throws Exception {
        Map<String, List<?>> searchResults = createSearchResults();
        Mockito.when(searchService.searchCatalog(Mockito.anyString(), Mockito.anyString())).thenReturn(searchResults);

        mockMvc.perform(get("/zoek/catalog")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchCatalogTestEmptyLists() throws Exception {
        Mockito.when(searchService.searchCatalog(Mockito.anyString(), Mockito.anyString())).thenReturn(createEmptySearchResults());

        mockMvc.perform(get("/zoek/catalog")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchCatalogTestLoc() throws Exception {
        Map<String, List<?>> searchResults = createEmptySearchResults();
        searchResults.remove("car");

        Mockito.when(searchService.searchCatalog(Mockito.anyString(), Mockito.anyString())).thenReturn(searchResults);

        mockMvc.perform(get("/zoek/catalog")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchDccTestLocCar() throws Exception {
        Map<String, List<?>> searchResults = createSearchResults();
        Mockito.when(searchService.searchDccAddress(Mockito.anyString(), Mockito.anyString())).thenReturn(searchResults);

        mockMvc.perform(get("/zoek/dcc")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchDccTestEmptyLists() throws Exception {
        Mockito.when(searchService.searchDccAddress(Mockito.anyString(), Mockito.anyString())).thenReturn(createEmptySearchResults());

        mockMvc.perform(get("/zoek/dcc")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchDccTestLoc() throws Exception {
        Map<String, List<?>> searchResults = createEmptySearchResults();
        searchResults.remove("car");

        Mockito.when(searchService.searchDccAddress(Mockito.anyString(), Mockito.anyString())).thenReturn(searchResults);

        mockMvc.perform(get("/zoek/dcc")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchBrTestLocCar() throws Exception {
        Map<String, List<?>> searchResults = createSearchResults();
        Mockito.when(searchService.searchBuildSeries(Mockito.anyString(), Mockito.anyString())).thenReturn(searchResults);

        mockMvc.perform(get("/zoek/br")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchBrTestEmptyLists() throws Exception {
        Mockito.when(searchService.searchBuildSeries(Mockito.anyString(), Mockito.anyString())).thenReturn(createEmptySearchResults());

        mockMvc.perform(get("/zoek/br")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    @Test
    public void searchBrTestLoc() throws Exception {
        Map<String, List<?>> searchResults = createEmptySearchResults();
        searchResults.remove("car");

        Mockito.when(searchService.searchBuildSeries(Mockito.anyString(), Mockito.anyString())).thenReturn(searchResults);

        mockMvc.perform(get("/zoek/br")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("resultView"));
    }

    private Map<String, List<?>> createEmptySearchResults() {
        Map<String, List<?>> ownerList = new HashMap<String, List<?>>();
        ownerList.put("loc", new ArrayList<Locomotive>());
        ownerList.put("car", new ArrayList<Waggon>());
        return ownerList;
    }

    private Map<String, List<?>> createSearchResults() {
        Map<String, List<?>> ownerList = new HashMap<String, List<?>>();
        ownerList.put("loc", LocListBuilder.getLocomotives());
        ownerList.put("car", CarListBuilder.getCars());
        return ownerList;
    }
}
