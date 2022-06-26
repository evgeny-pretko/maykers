package pageobject.pages;

import core.helpers.ProductIdConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.base.BasePage;

public class SearchPage extends BasePage {

    private final By searchResultText = By.tagName("h1");
    private final By productIdList = By.xpath("//div[@class=\"card-content\"]/div");
    private final By brandSearchBar = By.cssSelector("input[id*=\"BrandSearchBar\"]");
    private final By priceRangeUpper = By.cssSelector("div.noUi-handle-upper");
    private final By priceMaxInput = By.cssSelector("input[id*=\"maxInputId\"]");


    public String getSearchResultText() {
        return getDriver().findElement(searchResultText).getText();
    }

    public void scrollToProductByIdAndOpen(String id) {
        WebElement element = getDriver().findElements(productIdList)
                .stream()
                .filter(h -> h.getText().contains(ProductIdConverter.convertId(id)))
                .findFirst().get();

        jsExecutor.scrollTo(element);
        jsExecutor.clickElement(element);
    }

    public void updatePriceRangeUpper(int value) {
        jsExecutor.scrollTo(getDriver().findElement(brandSearchBar));

        Actions actions = new Actions(getDriver());
        actions
                .moveToElement(getDriver().findElement(priceMaxInput))
                .doubleClick()
                .sendKeys(Keys.BACK_SPACE, String.valueOf(value), Keys.ENTER)
                .perform();
    }

    public void updatePriceRangeUpper() {
        jsExecutor.scrollTo(getDriver().findElement(brandSearchBar));

        Actions actions = new Actions(getDriver());
        actions
                .moveToElement(getDriver().findElement(priceRangeUpper))
                .clickAndHold()
                .moveByOffset(500, 0)
                .release()
                .perform();
    }
}
