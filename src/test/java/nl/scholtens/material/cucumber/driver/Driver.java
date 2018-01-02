package nl.scholtens.material.cucumber.driver;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public static WebDriver getWebDriverFireFox(int width, int height) {
        System.setProperty("webdriver.gecko.driver", "/opt/java/lib/gecko-driver/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(width, height));
        return driver;
    }

    public static WebDriver getWebDriverChrome(int width, int height) {
        System.setProperty("webdriver.chrome.driver","/opt/java/lib/chrome-driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(width, height));
        return driver;
    }


}
