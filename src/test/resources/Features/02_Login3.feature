Feature: User Login



  @Regression
  Scenario: Login with valid credentials
    Given user is on login page
    When user enters valid credentials
    Then user should be logged in successfully