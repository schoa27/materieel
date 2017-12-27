package nl.scholtens.material.cucumber.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.scholtens.material.cucumber.MaterialFeatureTest;
import nl.scholtens.material.cucumber.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SelectLanguageSteps extends MaterialFeatureTest {

    private WebDriver driver;

    @Given("^De browser is gestart$")
    public void deBrowserIsGestart() {
        driver = Driver.getWebDriverChrome(1240, 650);
        Assert.assertThat(this.driver, not(nullValue()));

    }

    @Given("^De setup pagina is geopend$")
    public void deSetupPaginaIsGeopend() {
        driver.get("http://localhost:8085/material");

    }

    @When("^Selecteer de Nederlandse taal in Dropdown overzicht Change the language$")
    public void selecteerDeNederlandseTaalInDropdownOverzichtChangeTheLanguage() {
        driver.findElement(By.id("locales")).findElement(By.name("nl")).click();
//        driver.findElement(By.name("padxml"))
//                .sendKeys("/home/schoa27/temp/rocrail/loc.xml");
//        driver.findElement(By.name("padafbeelding"))
//                .sendKeys("/home/schoa27/temp/rocrail/image/");
         driver.findElement(By.id("setup_submit")).click();
    }

    @Then("^De Setup pagina wordt getoond in het nederlands getoond$")
    public void deSetupPaginaWordtGetoondInHetNederlandsGetoond() throws Throwable {
        Assert.assertThat(driver.findElement(By.id("language_result")).getText(), equalToIgnoringCase("Nederlands"));
        Thread.sleep(1500);
        driver.close();
    }
}
