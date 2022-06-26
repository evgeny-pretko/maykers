package pageobject.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageobject.base.BasePage;

public class SearchBarComponent extends BasePage {

    private final By searchField = By.xpath("//input[@type=\"search\"]");
    private final By searchSuggestion = By.cssSelector("li.search-item.ui-menu-item");
    private final By searchSuggestionIcon = By.cssSelector("div.svg-icon.keyword");


    public void enterKeyword(String keyword) {
        getDriver().findElement(searchField).sendKeys(keyword);
    }

    public void enterKeywordAndDoSearch(String keyword) {
        getDriver().findElement(searchField).sendKeys(keyword, Keys.ENTER);
    }

    public void clickSuggestedValue(int id) {
        waitElementIsVisible(getDriver().findElements(searchSuggestion).get(id)).click();
    }

    public void checkSuggestedValuesAreShown() {
        waitElementIsVisible(getDriver().findElement(searchSuggestionIcon));
    }

}
