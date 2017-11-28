package nl.scholtens.material.service;

import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.mapper.MaterialMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(MockitoJUnitRunner.class)
public class LocServiceTest {

    private List<Locomotive> locomotives = new ArrayList<>();

    @InjectMocks
    private LocService locService = new LocServiceImpl();

    @Mock
    private MaterialMapper mapper;


    @Before
    public void setup() {
        createLocList();
        addSlaveLoc();
    }


    @Test
    public void getLocListTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getLocList(Mockito.anyString())).thenReturn(locomotives);
        Assert.assertThat(locService.getLocList("file").isEmpty(), not(true));
    }

    @Test
    public void getLocByIdTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getLocList(Mockito.anyString())).thenReturn(locomotives);
        Assert.assertThat(locService.getLocById("0", "file").getId(), is(0));
    }

    @Test
    public void getLocByLocId() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getLocList(Mockito.anyString())).thenReturn(locomotives);
        Assert.assertThat(locService.getLocByLocId("1", "file").getLocid(), is("1"));
    }


    @Test
    public void getLocByLocIdWithSlaves() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getLocList(Mockito.anyString())).thenReturn(locomotives);
        Assert.assertThat(locService.getLocByLocId("0", "file").getLocid(), is("0"));
    }

    @Test
    public void fileIOExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getLocList("file")).thenThrow(new IOException());
        Assert.assertThat(locService.getLocList("file"), nullValue());
    }

    @Test
    public void xmlJAXBExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getLocList("file")).thenThrow(new JAXBException("JAXBExeption"));
        Assert.assertThat(locService.getLocList("file"), nullValue());
    }

    @Test
    public void xmlSAXExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getLocList("file")).thenThrow(new SAXException());
        Assert.assertThat(locService.getLocList("file"), nullValue());
    }

    @Test
    public void fileNotFoundExaptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getLocList("file")).thenThrow(new FileNotFoundException());
        Assert.assertThat(locService.getLocList("file"), nullValue());
    }

    private void createLocList() {
        for (int i = 0; i < 5; i++) {
            Locomotive locomotive = new Locomotive();
            locomotive.setId(i);
            locomotive.setLocid(String.valueOf(i));
            locomotives.add(locomotive);
        }
    }

    private void addSlaveLoc() {
        locomotives.get(0).setSlaveLocIds("1,2");
    }
}
