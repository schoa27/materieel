package nl.scholtens.material.service;

import nl.scholtens.material.domain.Waggon;
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
public class CarServiceTest {

    private List<Waggon> waggons = new ArrayList<>();

    @InjectMocks
    private CarService carService = new CarServiceImpl();

    @Mock
    private MaterialMapper mapper;


    @Before
    public void setup() {
        createWaggonsList();
    }

    @Test
    public void getCarListTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getCarList(Mockito.anyString())).thenReturn(waggons);
        Assert.assertThat(carService.getCarList("file").isEmpty(), not(true) );
    }

    @Test
    public void getCarByIdTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getCarList(Mockito.anyString())).thenReturn(waggons);
        Waggon carById = carService.getCarById("1", "file");
        Assert.assertThat(carService.getCarById("1", "file").getId(), is(1));
    }

    @Test
    public void fileIOExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getCarList("file")).thenThrow(new IOException());
        Assert.assertThat(carService.getCarList("file"), nullValue());
    }

    @Test
    public void xmlJAXBExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getCarList("file")).thenThrow(new JAXBException("JAXBExeption"));
        Assert.assertThat(carService.getCarList("file"), nullValue());
    }

    @Test
    public void xmlSAXExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getCarList("file")).thenThrow(new SAXException());
        Assert.assertThat(carService.getCarList("file"), nullValue());
    }

    @Test
    public void fileNotFoundExaptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getCarList("file")).thenThrow(new FileNotFoundException());
        Assert.assertThat(carService.getCarList("file"), nullValue());
    }

    private void createWaggonsList() {
        for (int i = 0; i < 5; i++) {
            Waggon waggon = new Waggon();
            waggon.setId(i);
            waggon.setCarid(String.valueOf(i));
            waggons.add(waggon);
        }
    }
}
