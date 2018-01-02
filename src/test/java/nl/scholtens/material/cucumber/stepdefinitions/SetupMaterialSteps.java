package nl.scholtens.material.cucumber.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.scholtens.material.cucumber.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public class SetupMaterialSteps {

    public static final String XML_FILE = "/home/schoa27/temp/rocrail/loc.xml";
    public static final String IMAGE_PATH = "/home/schoa27/temp/rocrail/image/";

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
        driver.close();
    }

    @When("^Pad voor het XML bestand wordt in gevuld$")
    public void padVoorHetXMLBestandWordtInGevuld() throws Throwable {
        driver.findElement(By.name("padxml")).sendKeys(XML_FILE);
    }

    @When("^Pad voor de afbeedling wordt in gevuld$")
    public void padVoorDeAfbeedlingWordtInGevuld() throws Throwable {
        driver.findElement(By.name("padafbeelding")).sendKeys(IMAGE_PATH);
    }

    @When("^Wordt op de Doorgaan knop gedrukt$")
    public void wordtOpDeDoorgaanKnopGedrukt() throws Throwable {
        driver.findElement(By.id("setup_submit")).click();
    }

    @Then("^Overzicht pagina wordt getoond met alle instellingen$")
    public void overzichtPaginaWordtGetoondMetAlleInstellingen() throws Throwable {
        Assert.assertThat(driver.findElement(By.id("xmlpath")).getText(), equalTo(XML_FILE));
        Assert.assertThat(driver.findElement(By.id("imagepath")).getText(), equalTo(IMAGE_PATH));
        Assert.assertThat(driver.findElement(By.id("language_result")).getText(), equalTo("Nederlands"));
    }
}
