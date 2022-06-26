package core.driver;

import core.helpers.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver localDriver = null;

    public static void createDriver() {

        switch(ConfigProvider.BROWSER) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                localDriver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                localDriver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("There is an issue with driver set up");
        }

        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.IMPLICIT_WAIT));
        localDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigProvider.PAGE_LOAD));
    }

    public static WebDriver getDriver() {
        if (localDriver != null) {
            return localDriver;
        } else {
            throw new RuntimeException("There is an issue with driver");
        }
    }

    public static void cleanUpDriver() {
        if (localDriver != null) {
            localDriver.quit();
        }
    }
}
