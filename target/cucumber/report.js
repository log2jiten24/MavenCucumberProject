$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:featurefiles/Login.feature");
formatter.feature({
  "name": "Login OpenOrangeHRM page and logout",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login and navigate to dashboard",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is already on home page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinition.user_already_on_loginpage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "title of login page is OrangeHRM",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinition.verify_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \u0027Admin\u0027 and \u0027admin123\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.EnterCredentials(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.loginclick()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is navigated to OrangeHRM Dashboard Page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.navigatedashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create new user and verify the new user and logout",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is already on dashboard page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinition.user_already_on_dashboardpage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to User button and clicks on User link",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinition.usernavigatetoUserLink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Add Button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinition.user_clicks_addbutton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Selects User Role",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.user_select_userrole()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters EmployeeName and Username as \u0027jeet2300\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.enterdetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters Password details",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.enterPasswordDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Save Button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.clickSaveButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Searches with Username as \u0027jeet2300\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.UserNameSearch(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the User is successfully added",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.VerifyUserName()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logouts the OrangeHRM Application",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.LogoutHRMApplication()"
});
formatter.result({
  "status": "passed"
});
});