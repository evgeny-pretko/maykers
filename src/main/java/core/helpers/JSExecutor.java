package core.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutor {

    private JavascriptExecutor executor;

    public JSExecutor(WebDriver driver) {
        this.executor = (JavascriptExecutor) driver;
    }

    public void clickElement(WebElement element) {
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollTo(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void updateValueAttribute(WebElement element, String value) {
        executor.executeScript("arguments[0].value='" + value + "';", element);
    }

}