Feature: User Registration

  Scenario: Successful account registration
    Given user is on registration page
    When user enters name "New Data" and email "newdata@gmail.com"
    And fills out all required registration details
    Then registration should be successful with message "Account Created!"