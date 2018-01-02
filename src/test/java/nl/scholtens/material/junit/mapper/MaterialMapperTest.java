package nl.scholtens.material.junit.mapper;

import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.OperatorTrain;
import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.mapper.MaterialMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * This test class uses test.xml witch is located in root of the project.
 * Do not DELETE this file. The Test will nor run if you delete the file.
 */
@RunWith(JUnit4.class)
public class MaterialMapperTest {

    private MaterialMapper mapper = new MaterialMapper();

    @Test
    public void getLocListTest() throws JAXBException, SAXException, IOException {
        List<Locomotive> locList = mapper.getLocList("test.xml");
        Assert.assertThat(locList, notNullValue());
        Assert.assertThat(locList.isEmpty(), is(false));
    }

    @Test
    public void getCarListTest() throws JAXBException, SAXException, IOException {
        List<Waggon> carList = mapper.getCarList("test.xml");
        Assert.assertThat(carList, notNullValue());
        Assert.assertThat(carList.isEmpty(), is(false));
    }

    @Test
    public void getOperatorListTest() throws JAXBException, SAXException, IOException {
        List<OperatorTrain> operatorList = mapper.getOperatorList("test.xml");
        Assert.assertThat(operatorList, notNullValue());
        Assert.assertThat(operatorList.isEmpty(), is(false));
    }
}
