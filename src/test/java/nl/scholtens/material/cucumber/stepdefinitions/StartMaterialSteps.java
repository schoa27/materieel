package nl.scholtens.material.cucumber.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.scholtens.material.cucumber.MaterialFeatureTest;
import nl.scholtens.material.cucumber.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;


public class StartMaterialSteps extends MaterialFeatureTest {

    private WebDriver driver;

    @Given("^De browser wordt gestart$")
    public void deBrowserWordtGestart() throws Throwable {
        System.out.println("De browser wordt gestart");
//        driver = Driver.getWebDriverFireFox();
        driver = Driver.getWebDriverChrome(1300, 700);
        Assert.assertThat(this.driver, not(nullValue()));
    }

    @When("^Het adres van Materieel Overzicht wordt in gevuld in dres balk$")
    public void hetAdresVanMaterieelOverzichtWordtInGevuldInDresBalk() throws Throwable {
        System.out.println("Het adres van Materieel Overzicht wordt in gevuld in dres balk");
        driver.get("http://localhost:8085/material");
    }

    @Then("^Setup pagina van Materieel Overzicht wordt getoond$")
    public void setupPaginaVanMaterieelOverzichtWordtGetoond() throws Throwable {
        System.out.println("Setup pagina van Materieel Overzicht wordt getoond");
        Assert.assertThat(driver.getCurrentUrl(), is("http://localhost:8085/setup"));
        driver.close();
    }



}
