package steps;

import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import pageobject.pages.HomePage;

public class HomeStep extends HomePage {

    @Given("page URL {string} is opened")
    public void iOpenPage(String url) {
        openUrl(url);
    }

    @Given("home page URL {string} is opened")
    public void iOpenHomePage(String url) {
        openUrl(url);
        checkCategoryTitleIsDisplayed();
    }

    public void checkCategoryTitleIsDisplayed() {
        Assertions.assertNotNull(getCategoryTitle());
    }

}