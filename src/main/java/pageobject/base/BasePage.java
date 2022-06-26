package pageobject.base;

import core.driver.Driver;
import core.helpers.ConfigProvider;
import core.helpers.JSExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    protected JSExecutor jsExecutor =  new JSExecutor(getDriver());

    public WebDriver getDriver() {
        return Driver.getDriver();
    }

    public void openUrl(String url) {
        getDriver().get(url);
    }

    /**
     * Check if current url contains substring
     * @param urlSubstring
     * @return true if contains
     */
    public Boolean checkCurrentUrl(String urlSubstring) {
        return getDriver().getCurrentUrl().contains(urlSubstring);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigProvider.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitElementDisappear(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigProvider.IMPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOf(element));
    }

}
