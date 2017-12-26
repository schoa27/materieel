package nl.scholtens.material.cucumber.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public static WebDriver getWebDriverFireFox() {
        System.setProperty("webdriver.gecko.driver", "/opt/java/lib/gecko-driver/geckodriver");
        return new FirefoxDriver();
    }

    public static WebDriver getWebDriverChrome() {
        System.setProperty("webdriver.chrome.driver","/opt/java/lib/chrome-driver/chromedriver");
        return new ChromeDriver();
    }
}
