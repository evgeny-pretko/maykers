@ui
Feature: Search product in the catalog

  Background: User is on a home page
    Given home page URL "https://www.maykers.com/en-dk/home" is opened

  @smoke @regression
  Scenario Outline: Search a product and check that search results are displayed for provided keyword
    When I enter <keyword> text into a search bar and do search
    Then search page is displayed
    And search results for <keyword> are present
  Examples:
    | keyword |
    | "grill" |
    | "grass" |

  Scenario: Change price range upper border
    When I enter "sheep" text into a search bar and do search
    And I update price upper range to 4000
    And I set price upper range to maximum

  @regression
  Scenario: Search a product using suggested entry
    When I enter "sheep" text into a search bar
    Then I see suggested search values
    When I click suggested value 4
    Then search page is displayed

  @smoke @regression
  Scenario: Search a product and open product details
    When I enter "drill" text into a search bar and do search
    And I find and open the product with id "EAN4007430285850"
    Then product page is displayed
