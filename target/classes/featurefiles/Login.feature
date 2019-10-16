Feature: Login OpenOrangeHRM page and logout 

Scenario: Login and logout Scenario

Given User is already  on home page
When title of login page is OrangeHRM
And User enters Username and Password
And User clicks on login button
Then User is navigated to OrangeHRM Dashboard Page 