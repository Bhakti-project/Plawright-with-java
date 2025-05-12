Feature: Verify Products and Product Detail

	@Smoke
  Scenario: User can view products and their detail
   When user clicks on Products link
   Then user should see the products list
   When user clicks on "View Product" of the first item
    Then user should see the product detail page with title "Blue Top"
    
    @Regression
    Scenario: Find and add T-Shirts and Tops products to cart
    Given user navigate to the Products page
    When user filter products as "Top" and "Tshirt"
    And user naviagte to the cart
    Then user should see "Top" and "Tshirt" products added in to the cart