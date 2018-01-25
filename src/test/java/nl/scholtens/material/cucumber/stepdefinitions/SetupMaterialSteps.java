package nl.scholtens.material.cucumber.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.scholtens.material.cucumber.MaterialFeatureTest;
import nl.scholtens.material.cucumber.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public class SetupMaterialSteps extends MaterialFeatureTest {

    public static final String XML_FILE = "/home/schoa27/rocrail/plans/smiplePlan/loc.xml";
    public static final String IMAGE_PATH_SMALL = "/home/schoa27/rocrail/images/small/";
    public static final String IMAGE_PATH_LARGE = "/home/schoa27/rocrail/images/large/";

    private WebDriver driver;

    @Given("^De browser is gestart$")
    public void deBrowserIsGestart() throws Throwable {
        driver = Driver.getWebDriverChrome(1300, 700);
        Assert.assertThat(driver, not(nullValue()));
        driver.get("http://localhost:8085/material");
    }

    @Given("^De setup pagina is geopend$")
    public void deSetupPaginaIsGeopend() throws Throwable {
        Assert.assertThat(driver.getTitle(), comparesEqualTo("Material Overview"));
    }

    @When("^Selecteer de Nederlandse taal in Dropdown overzicht Change the language$")
    public void selecteerDeNederlandseTaalInDropdownOverzichtChangeTheLanguage() throws Throwable {
        driver.findElement(By.id("locales")).findElement(By.name("nl")).click();
    }

    @Then("^De Setup pagina wordt getoond in het nederlands getoond$")
    public void deSetupPaginaWordtGetoondInHetNederlandsGetoond() throws Throwable {
        Assert.assertThat(driver.findElement(By.name("nl")).getText(), equalToIgnoringCase("Nederlands"));
    }

    @When("^Pad voor het XML bestand wordt in gevuld$")
    public void padVoorHetXMLBestandWordtInGevuld() throws Throwable {
        driver.findElement(By.name("pathxml")).sendKeys(XML_FILE);
    }
//
//    @When("^Pad voor de afbeedling wordt in gevuld$")
//    public void padVoorDeAfbeedlingWordtInGevuld() throws Throwable {
//        driver.findElement(By.name("padafbeelding")).sendKeys(IMAGE_PATH_SMALL);
//    }


    @When("^Pad voor kleine de afbeedlingen wordt in gevuld$")
    public void padVvoorKleineDeAfbeedlingenWordtInGevuld() throws Throwable {
        driver.findElement(By.name("pathimagesmall")).sendKeys(IMAGE_PATH_SMALL);

    }

    @When("^Pad voor grote de afbeedlingen wordt in gevuld$")
    public void padVoorGroteDeAfbeedlingenWordtInGevuld() throws Throwable {
        driver.findElement(By.name("pathimagelarge")).sendKeys(IMAGE_PATH_LARGE);

    }

    @When("^Wordt op de Doorgaan knop gedrukt$")
    public void wordtOpDeDoorgaanKnopGedrukt() throws Throwable {
        driver.findElement(By.id("setup_submit")).click();
    }

    @Then("^Overzicht pagina wordt getoond met alle instellingen$")
    public void overzichtPaginaWordtGetoondMetAlleInstellingen() throws Throwable {
        Assert.assertThat(driver.findElement(By.id("xmlpath")).getText(), equalTo(XML_FILE));
        Assert.assertThat(driver.findElement(By.id("imagepathsmall")).getText(), equalTo(IMAGE_PATH_SMALL));
        Assert.assertThat(driver.findElement(By.id("imagepathlarge")).getText(), equalTo(IMAGE_PATH_LARGE));
        Assert.assertThat(driver.findElement(By.id("language_result")).getText(), equalTo("Nederlands"));
    }


    @When("^Bij volgende pagina wordt op de knop Locomotief Overzicht gedrukt$")
    public void bijVolgendePaginaWordtOpDeKnopLocomotiefOverzichtGedrukt() throws Throwable {
        driver.findElement(By.name("loc")).click();
    }

    @Then("^wordt een lijst met locomotieven getoond$")
    public void wordtEenLijstMetLocomotievenGetoond() throws Throwable {
        Assert.assertThat(driver.findElement(By.id("loc_overview")).getText(), equalTo("Locomotief Overzicht"));
    }

    @When("^Bij volgende pagina wordt op de knop Wagen Overzicht gedrukt$")
    public void bijVolgendePaginaWordtOpDeKnopWagenOverzichtGedrukt() throws Throwable {
        driver.findElement(By.name("car")).click();

    }

    @Then("^wordt een lijst met Waggons getoond$")
    public void wordtEenLijstmetWaggonsGetoond() throws Throwable {
        Assert.assertThat(driver.findElement(By.id("car_overview")).getText(), equalTo("Wagen Overzicht"));
    }


    @Then("^De browser wordt gesloten$")
    public void deBrowserWordtGesloten() throws Throwable {
        driver.close();
    }
}
