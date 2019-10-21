Feature: Create new user from orangehrm page map feature

  Scenario: New User creation through orange hrm
    Given User is already on home page
    When title of login page is OrangeHRM
    #data table is applicable for single step
    And User enters Map  Username and Password
      | Username | Password |
      | Admin    | admin123 |
    #0th row zero element
    And User clicks on login button
    Then User is navigated to OrangeHRM Dashboard Page
    When User navigates to User button and clicks on User link
    When User clicks on Add Button
    And User Selects User Role
    And User enters Mapexample  EmployeeName and Username
      | EmployeeName   | Username |
      | John Smith     | jiten789 |
      | Jasmine Morgan | jiten800 |
    And User enters Password details
    And User clicks on Save Button
    And User Searches with Username Map
      | username |
      | jiten789 |
      | jiten800 |
    Then Verify the User is successfully added
    And User logouts the OrangeHRM Application
