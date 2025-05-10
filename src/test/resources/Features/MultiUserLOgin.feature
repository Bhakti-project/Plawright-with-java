Feature: Login the Apllication with multiple user

  Scenario Outline: Login the Application with multiple credentials
  
    Given User navigates to home page
    And User clicks on SignIN button
    When User enters the email as "<email>" and password as "<password>"
    And User clicks on Login button
    Then user should navigate to home page
    
    Examples:
      | email                       | password     |
      | Bhaktitest@gmail.com        | Bhakti@Test  |
      | uniqueuser1234341@gmail.com | check123@123 |
		

    