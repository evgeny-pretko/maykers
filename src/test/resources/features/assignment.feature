Feature: Use case from the technical assignment

  @endToEnd @ui
  Scenario: As logged in user search a product, add to cart, increase quantity
    Given home page URL "https://maykers-tst.outsystemsenterprise.com/en-dk/home?(Not.Licensed.For.Production)=" is opened
    When I login with credentials
        | motestmk+qacandidate@gmail.com  | QaCandidate&65  |
    And I enter "led" text into a search bar
    Then I see suggested search values
    When I click suggested value 3
    Then search page is displayed
    When I find and open the product with id "MPN1400650300"
    Then product page is displayed
    When I sort shipping by "Fast delivery"
    And I add first deal to cart
    And I go to cart from popup
    Then cart page is displayed
    And product quantity in the cart is 1
    When I increase the quantity 2 times
    Then product quantity in the cart is 2
    When I delete product from the cart
    Then cart page is displayed
