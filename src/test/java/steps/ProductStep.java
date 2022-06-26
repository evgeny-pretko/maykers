package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobject.pages.ProductPage;

public class ProductStep extends ProductPage {

    @When("I add first deal to cart")
    public void iAddFirstDealToCart() {
        addFirstDealToCart();
    }

    @When("I go to cart from popup")
    public void iGoToCartFromPopup() {
        goToCartFromPopup();
    }

    @When("I sort shipping by {string}")
    public void iSortShippingBy(String sortOption) {
        selectSortOption(sortOption);
    }

    @Then("product page is displayed")
    public void productPageIsDisplayed() {
        Assertions.assertTrue(checkCurrentUrl("/products"));
    }

}
