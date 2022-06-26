package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.base.BasePage;

public class HomePage extends BasePage {

    private final By categoryTitle = By.cssSelector("div.category-block-title");


    public String getCategoryTitle() {
        return waitElementIsVisible(getDriver().findElement(categoryTitle)).getText();
    }

}