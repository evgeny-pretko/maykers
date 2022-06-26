package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.base.BasePage;

public class ProductPage extends BasePage {

    private final By addToCartButton = By.cssSelector("div.pol-bot-section a");
    private final By goToCartPopupButton = By.xpath("//div[@class=\"pdp-ph-right\"]//a[@class=\"ButtonLink3\"]/../div");
    private final By sortByDelivery = By.xpath("//a[text()=\"Fast delivery\"]");
    private final By sortByPrice = By.xpath("//a[text()=\"Price\"]");
    private final By sortOptionSelector = By.cssSelector("span[id*=\"SortOption_block\"] div.dropdown-balloon-link");


    public void addFirstDealToCart() {
        waitElementIsVisible(getDriver().findElements(addToCartButton).get(0)).click();
    }

    public void goToCartFromPopup() {
        waitElementIsVisible(getDriver().findElement(goToCartPopupButton)).click();
    }

    public void selectSortOption(String sortOption) {
        waitElementIsVisible(getDriver().findElement(sortOptionSelector)).click();

        switch (sortOption) {
            case "Price":
                waitElementIsVisible(getDriver().findElement(sortByPrice)).click();
                break;
            case "Fast delivery":
                waitElementIsVisible(getDriver().findElement(sortByDelivery)).click();
                break;
            default:
                throw new RuntimeException("Incorrect sort option");
        }
    }

}
