Feature: Product Page scroll functinality

Scenario: scroll to the bottom again scroll to the top
Given user is on Product page
When user scroll to the bottom
Then user should see the bottom of the page
When Again user scroll to the Top
Then user should see the Top of the page
 