package nl.scholtens.material.service;

import nl.scholtens.material.domain.Decoder;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.OperatorTrain;
import nl.scholtens.material.domain.Waggon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {


    @InjectMocks
    private SearchService searchService = new SearchServiceImpl();

    @Mock
    private LocService locService;

    @Mock
    private CarService carService;

    private List<Locomotive> locomotives = new ArrayList<>();

    private List<Waggon> waggons = new ArrayList<>();

    private List<Locomotive> locResults;

    private List<Waggon> waggonResults;


    @Before
    public void setup() {
        createLocList();
        createWaggonsList();

        Mockito.when(locService.getLocList(Mockito.anyString())).thenReturn(locomotives);
        Mockito.when(carService.getCarList(Mockito.anyString())).thenReturn(waggons);
    }

    @Test
    public void searchOwnerTest() {
        Map<String, List<?>> result = searchService.searchOwner("owner", "file");
        getResults(result);

        Assert.assertThat(locResults.isEmpty(), not(true));
        Assert.assertThat(waggonResults.isEmpty(), not(true));
        Assert.assertThat(locResults.get(0).getOwner(), is("Owner"));
        Assert.assertThat(waggonResults.get(0).getManufactor(), is("Owner"));
    }

    @Test
    public void searchCatalog() {
        Map<String, List<?>> result = searchService.searchCatalog("CT12345", "file");
        getResults(result);

        Assert.assertThat(locResults.isEmpty(), not(true));
        Assert.assertThat(waggonResults.isEmpty(), not(true));
        Assert.assertThat(locResults.get(0).getCatalogNumber(), is("CT12345"));
        Assert.assertThat(waggonResults.get(0).getCatalognr(), is("CT12345"));
    }

    @Test
    public void searchDccAddressTest() {
        Map<String, List<?>> result = searchService.searchDccAddress("1", "file");
        getResults(result);

        Assert.assertThat(locResults.isEmpty(), not(true));
        Assert.assertThat(waggonResults.isEmpty(), not(true));
        Assert.assertThat(locResults.get(0).getDecoder().getAddress(), is(1));
        Assert.assertThat(waggonResults.get(0).getDecoder().getAddress(), is(1));
    }

    @Test
    public void searchBr() {
        Map<String, List<?>> result = searchService.searchBuildSeries("br","file");
        Assert.assertThat(result.containsKey("loc"), is(true));

        locResults = (List<Locomotive>) result.get("loc");

        Assert.assertThat(locResults.isEmpty(), not(true));
        Assert.assertThat(locResults.get(0).getLocid(), is("br"));
    }


    private void getResults(Map<String, List<?>> result) {
        Assert.assertThat(result.containsKey("loc"), is(true));
        Assert.assertThat(result.containsKey("car"), is(true));

        locResults = (List<Locomotive>) result.get("loc");
        waggonResults = (List<Waggon>) result.get("car");
    }

    private void createLocList() {
        for (int i = 0; i < 5; i++) {
            Locomotive locomotive = new Locomotive();
            locomotive.setId(i);
            locomotive.setLocid(String.valueOf(i));
            locomotive.setLength(i);
            locomotive.setLocid("br");
            locomotive.setOwner("Owner");
            locomotive.setCatalogNumber("CT12345");
            locomotive.setDecoder(createDecoder());
            locomotives.add(locomotive);
        }

        List<Locomotive> slaves = new ArrayList<>();
        slaves.add(locomotives.get(1));
        locomotives.get(0).setSlaveLocList(slaves);
    }

    private void createWaggonsList() {
        for (int i = 0; i < 5; i++) {
            Waggon waggon = new Waggon();
            waggon.setId(i);
            waggon.setCarid(String.valueOf(i));
            waggon.setLength(i);
            waggon.setCarid("br");
            waggon.setManufactor("Owner");
            waggon.setCatalognr("CT12345");
            waggon.setDecoder(createDecoder());
            waggons.add(waggon);
        }
    }

    private Decoder createDecoder() {
        Decoder decoder = new Decoder();
        decoder.setAddress(1);
        return decoder;
    }
}
