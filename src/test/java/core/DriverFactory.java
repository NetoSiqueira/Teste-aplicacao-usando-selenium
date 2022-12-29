package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {

    }

    public static WebDriver getDriver(){
        if(driver == null) {
            switch (Propriedades.browser){
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    ChromeOptions chrome = new ChromeOptions();
                    chrome.addArguments("disable-notifications");
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    FirefoxOptions firefox = new FirefoxOptions();
                    firefox.addArguments("disable-notifications");
                    break;
            }

        }
        return driver;
    }

    public static void killDriver(){
        if(driver != null) {
            getDriver().quit();
            driver = null;
        }
    }
}
