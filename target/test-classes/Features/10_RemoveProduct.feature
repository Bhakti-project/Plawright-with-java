Feature: Remove the product from Cart

@Regression  @Smoke
 Scenario: Remove a product from the cart
    Given I have added a product to the cart
    When I navigate to the cart page
    And I remove the product from the cart
    Then The cart should be empty and should see a message "Cart is empty!"