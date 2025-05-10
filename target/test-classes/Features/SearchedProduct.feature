Feature: Product Search

  Scenario: User can search for a product by name
    Given user is on the home page
    When user clicks on products link
    And user searches for product "Tshirt"
    Then products related to "Tshirt" should be visible as "Searched Products"

	 Scenario: Count and print all products on the Products page
    Given user is on the Products page
    Then all product names should be printed with total count