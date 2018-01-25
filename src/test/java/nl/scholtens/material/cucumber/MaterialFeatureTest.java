package nl.scholtens.material.cucumber;

import nl.scholtens.material.cucumber.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public abstract class MaterialFeatureTest {

    protected WebDriver driver;

}
