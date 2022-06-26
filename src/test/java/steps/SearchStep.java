package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobject.pages.SearchPage;

public class SearchStep extends SearchPage {

    @When("I find and open the product with id {string}")
    public void iFindAndOpenTheProductWithId(String id) {
        scrollToProductByIdAndOpen(id);
    }

    @When("I update price upper range to {int}")
    public void iUpdatePriceUpperRangeTo(int upperValue) {
        updatePriceRangeUpper(upperValue);
    }

    @When("I set price upper range to maximum")
    public void iSetPriceUpperRangeToMaximum() {
        updatePriceRangeUpper();
    }

    @Then("search page is displayed")
    public void searchPageIsDisplayed() {
        Assertions.assertTrue(checkCurrentUrl("/search"));
    }

    @Then("search results for {string} are present")
    public void searchResultsForKeywordArePresent(String keyword) {
        Assertions.assertTrue(getSearchResultText().contains(keyword));
    }

}