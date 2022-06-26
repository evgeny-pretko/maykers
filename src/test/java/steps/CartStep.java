package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobject.pages.CartPage;

public class CartStep extends CartPage {

    @When("I increase the quantity {int} times")
    public void iIncreaseTheQuantityTimes(int multiplier) {
        increaseQuantityXTimes(multiplier);
    }

    @When("I delete product from the cart")
    public void iDeleteProductFromTheCart() {
        deleteProductFromCart();
    }

    @Then("cart page is displayed")
    public void cartPageIsDisplayed() {

        Assertions.assertAll(
                () -> Assertions.assertEquals("Your cart", getPageTitle()),
                () -> Assertions.assertTrue(checkCurrentUrl("/cart"))
        );
    }

    @Then("product quantity in the cart is {int}")
    public void productQuantityInTheCartIs(int quantity) {
        Assertions.assertEquals(quantity, getProductQuantity());
    }
}
