Feature: Add product to cart

@endToEnd @ui
Scenario: Search a product, add to cart deal with the cheapest price
  Given home page URL "https://www.maykers.com/en-dk/home" is opened
  When I enter "drill" text into a search bar and do search
  And I find and open the product with id "EAN4007430285850"
  Then product page is displayed
  When I sort shipping by "Price"
  And I add first deal to cart
  And I go to cart from popup
  Then cart page is displayed
  And product quantity in the cart is 1
