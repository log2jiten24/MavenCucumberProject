Feature: Create new user from orangehrm page 

Scenario: New User creation through orange hrm 

Given User is already on home page
When title of login page is OrangeHRM
#data table is applicable for single step 
And User enters Username and Password
|Admin | admin123 |
#0th row zero element 
And User clicks on login button
Then  User is navigated to OrangeHRM Dashboard Page 
When  User navigates to User button and clicks on User link
When  User clicks on Add Button 
And   User Selects User Role 
And   User enters EmployeeName and Username 
|John Smith | jiten240000 |
And   User enters Password details 
And   User clicks on Save Button
And   User Searches with Username 
|jiten240000|
Then  Verify the User is successfully added 
And   User logouts the OrangeHRM Application 