Feature: Add a product review


	 @Regression
  Scenario: Submit a product review successfully
    Given user on the product details page
    When user add review with name "John Doe", email "john@example.com", and review "Great product!" 
    Then The review should be submitted successfully
    And Review added message should display
    