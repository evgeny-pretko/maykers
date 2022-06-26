package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.components.SearchBarComponent;

public class SearchBarStep extends SearchBarComponent {

    @When("I enter {string} text into a search bar")
    public void iEnterKeyword(String keyword) {
        enterKeyword(keyword);
    }

    @When("I enter {string} text into a search bar and do search")
    public void iEnterTextIntoASearchBarAndDoSearch(String keyword) {
        enterKeywordAndDoSearch(keyword);
    }

    @When("I click suggested value {int}")
    public void iClickSuggestedValue(int id) {
        clickSuggestedValue(id);
    }

    @Then("I see suggested search values")
    public void iSeeSuggestedSearchValues() {
        checkSuggestedValuesAreShown();
    }

}