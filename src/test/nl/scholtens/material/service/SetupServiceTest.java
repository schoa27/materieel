package nl.scholtens.material.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Stubber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class SetupServiceTest {

    @InjectMocks
    private SetupService setupService = new SetupServiceImpl();

    @Mock
    BufferedWriter bufferedWriter;

    @Mock
    BufferedReader bufferedReader;

    public SetupServiceTest() throws IOException {
    }

    @Before
    public void setup() {

    }

    @Test
    public void getDateTest() {
        Assert.assertThat(setupService.getDate("NL"), notNullValue());
        Assert.assertThat(setupService.getDate(null), notNullValue());
    }

    @Test
    public void writeSetupFileTest() throws IOException {
       Mockito.doNothing().when(bufferedWriter).write(Mockito.anyString());
       setupService.writeSetupFile("xml", "image");
    }

    @Test
    public void readSetupFileTest() throws IOException {
        setupService.readSetupFile();
    }

    @Test
    public void isFileEmptyTest() throws IOException {
         Mockito.when(bufferedReader.readLine()).thenThrow(new IOException());
         Assert.assertThat(setupService.isFileEmpty(), is(false));
    }

}
