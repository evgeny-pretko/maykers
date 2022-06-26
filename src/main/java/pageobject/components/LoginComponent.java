package pageobject.components;

import org.openqa.selenium.By;
import pageobject.base.BasePage;

public class LoginComponent extends BasePage {

    private final By loginButton = By.cssSelector("a[id*=\"LoginButton\"]");
    private final By loginPopupButton = By.cssSelector("input[id*=\"LoginButton\"]");
    private final By emailField = By.cssSelector("input[type=\"email\"]");
    private final By passwordField = By.cssSelector("input[type=\"password\"]");


    public void openLoginPopup() {
        getDriver().findElement(loginButton).click();
        waitElementIsVisible(getDriver().findElement(emailField));
    }

    public void loginWithCredentials(String username, String password) {
        getDriver().findElement(emailField).sendKeys(username);
        getDriver().findElement(passwordField).sendKeys(password);
        getDriver().findElement(loginPopupButton).click();
        waitElementDisappear(getDriver().findElement(loginPopupButton));
    }

}