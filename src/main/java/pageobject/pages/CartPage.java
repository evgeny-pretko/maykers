package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.base.BasePage;

public class CartPage extends BasePage {

    private final By pageTitle = By.xpath("//h1/div/span");
    private final By quantityField = By.cssSelector("div input[type=number]");
    private final By deleteProductButton = By.cssSelector("div[data-tid=\"deleteQuantity-btn\"]");


    public String getPageTitle() {
        return waitElementIsVisible(getDriver().findElement(pageTitle)).getText();
    }

    public int getProductQuantity() {
        return Integer.parseInt(getDriver().findElement(quantityField).getAttribute("value"));
    }

    public void increaseQuantityXTimes(int multiplier) {
        int quantityCurrent = Integer.parseInt(getDriver().findElement(quantityField).getAttribute("value"));

        jsExecutor.updateValueAttribute(getDriver().findElement(quantityField), String.valueOf(quantityCurrent * multiplier));
    }

    public void deleteProductFromCart() {
        getDriver().findElement(deleteProductButton).click();
        waitElementDisappear(getDriver().findElement(deleteProductButton));
    }

}