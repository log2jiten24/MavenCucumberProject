

Feature: Login OpenOrangeHRM page and logout 

Scenario: Login and navigate to dashboard

#-Data driven testing without using example keyword 
@SmokeTest
Given User is already on home page
When title of login page is OrangeHRM
#data driven without using Examples keyword
And User enters 'Admin' and 'admin123'
And User clicks on login button
Then User is navigated to OrangeHRM Dashboard Page 

@RegressionTest
Scenario: Create new user and verify the new user and logout
Given User is already on dashboard page 
When  User navigates to User button and clicks on User link
When  User clicks on Add Button 
And   User Selects User Role 
And   User enters EmployeeName and Username as 'jeet2700'
And   User enters Password details 
And   User clicks on Save Button
And   User Searches with Username as 'jeet2700'
Then  Verify the User is successfully added 
And   User logouts the OrangeHRM Application 


@SmokeTest @RegressionTest
Scenario Outline: Login and navigate to dashboard using Examples keyword

##data driven  using Examples keyword
#make sure there is no similar type of steps 

Given User is already on home page
When title of login page is OrangeHRM

And User enters "<Username>" and "<Password>"
And User clicks on login button
Then User is navigated to OrangeHRM Dashboard Page and logout of the page 
Then User closes the browser 

Examples:
|Username |Password|
| Admin   |admin123|
| Jiten   |jiten123|
| Priya   |priya123|

#Examples keyword - data is applicable for the entire test case or scenario 

