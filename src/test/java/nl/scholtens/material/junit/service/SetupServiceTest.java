package nl.scholtens.material.junit.service;

import nl.scholtens.material.service.SetupService;
import nl.scholtens.material.service.SetupServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(MockitoJUnitRunner.class)
public class SetupServiceTest {

    @InjectMocks
    private SetupService setupService = new SetupServiceImpl();

    public SetupServiceTest() {
    }

    @Before
    public void setup() {
    }

    @Test
    public void getDateTest() {
        Assert.assertThat(setupService.getDate("NL"), notNullValue());
        Assert.assertThat(setupService.getDate(null), notNullValue());
    }

}
