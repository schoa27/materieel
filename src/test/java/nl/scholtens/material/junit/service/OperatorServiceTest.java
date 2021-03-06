package nl.scholtens.material.junit.service;

import nl.scholtens.material.junit.builders.CarListBuilder;
import nl.scholtens.material.junit.builders.LocListBuilder;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.OperatorTrain;
import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.mapper.MaterialMapper;
import nl.scholtens.material.service.CarService;
import nl.scholtens.material.service.LocService;
import nl.scholtens.material.service.OperatorService;
import nl.scholtens.material.service.OperatorServiceImpl;
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

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(MockitoJUnitRunner.class)
public class OperatorServiceTest {

    @InjectMocks
    private OperatorService operatorService = new OperatorServiceImpl();

    @Mock
    private LocService locService;

    @Mock
    private CarService carService;

    @Mock
    private MaterialMapper mapper;

    private List<OperatorTrain> operators = new ArrayList<>();

    private List<Waggon> waggons = new ArrayList<>();

    private List<Locomotive> locomotives = new ArrayList<>();

    @Before
    public void setup() throws IOException, JAXBException, SAXException {
        createLocList();
        createWaggonsList();
        createOperatorList();

        Mockito.when(mapper.getOperatorList(Mockito.anyString())).thenReturn(operators);
        Mockito.when(carService.getCarList(Mockito.anyString())).thenReturn(waggons);
        Mockito.when(locService.getLocList(Mockito.anyString())).thenReturn(locomotives);
    }

    @Test
    public void getOperatorListTest() {
        Assert.assertThat(operatorService.getOperatorList("file").isEmpty(), not(true));
    }

    @Test
    public void getOperatorByIdTest() throws IOException, JAXBException, SAXException {
        Mockito.when(locService.getLocByLocId("0", "file")).thenReturn(locomotives.get(0));

        OperatorTrain operatorById = operatorService.getOperatorById("0", "file");

        Assert.assertThat(operatorById.getId(), is("0"));
        Assert.assertThat(operatorById.getLocomotive(), notNullValue());
        Assert.assertThat(operatorById.getWaggons().isEmpty(), not(true));
    }

    @Test
    public void getOpertorByLocId() {
        Mockito.when(locService.getLocById(Mockito.anyString(), Mockito.anyString())).thenReturn(locomotives.get(0));

        OperatorTrain opertorByLocId = operatorService.getOpertorByLocId(String.valueOf(locomotives.get(0).getId()), "file ");
        Assert.assertThat(opertorByLocId.getLocId(), is("0"));
    }


    @Test
    public void fileIOExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getOperatorList("file")).thenThrow(new IOException());
        Assert.assertThat(operatorService.getOperatorList("file"), nullValue());
    }

    @Test
    public void xmlJAXBExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getOperatorList("file")).thenThrow(new JAXBException("JAXBExeption"));
        Assert.assertThat(operatorService.getOperatorList("file"), nullValue());
    }

    @Test
    public void xmlSAXExeptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getOperatorList("file")).thenThrow(new SAXException());
        Assert.assertThat(operatorService.getOperatorList("file"), nullValue());
    }

    @Test
    public void fileNotFoundExaptionTest() throws IOException, SAXException, JAXBException {
        Mockito.when(mapper.getOperatorList("file")).thenThrow(new FileNotFoundException());
        Assert.assertThat(operatorService.getOperatorList("file"), nullValue());
    }

    private void createOperatorList() {
        for (int i = 0; i < 2; i++) {
            OperatorTrain operator = new OperatorTrain();
            operator.setId(String.valueOf(i));
            operator.setCarIds("1,2,3");
            operator.setLocId(String.valueOf(i));
            operators.add(operator);
        }
    }

    private void createLocList() {
        locomotives = LocListBuilder.getLocomotives();

        List<Locomotive> slaves = new ArrayList<>();
        slaves.add(locomotives.get(1));
        locomotives.get(0).setSlaveLocList(slaves);
    }

    private void createWaggonsList() {
       waggons = CarListBuilder.getCars();
    }
}
