$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:featurefiles/Login.feature");
formatter.feature({
  "name": "Login OpenOrangeHRM page and logout",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@FunctionalTest"
    }
  ]
});
formatter.scenario({
  "name": "To check the hooks features of the cucumber",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@FunctionalTest"
    },
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on orangehrm page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinition.user_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters credentials\u0027Admin\u0027 and \u0027admin123\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinition.Enteruser(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logins successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.loginsuccess()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logout application",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.logoutsuccess()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});