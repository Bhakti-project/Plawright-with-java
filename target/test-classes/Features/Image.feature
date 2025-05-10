Feature: Screenshot Comparison

  @skip
  Scenario: Compare actual screenshot with expected image
    Given I navigate to the products page
    When I take a screenshot
    Then the screenshot should match the expected image