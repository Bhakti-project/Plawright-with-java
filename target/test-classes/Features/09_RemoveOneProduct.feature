Feature: Cart functionality


  Scenario: Add multiple products and remove one specific product
    Given user is on the product listing page
    When user adds multiple products to the cart
    And user navigates to the cart page
    And user removes the product named "Blue Top"
    Then the cart should not contain the product 
  