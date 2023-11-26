@login
Feature: Login functionality

test cases, 1 test case, 1 scenario
Scenario: Login with valid credentials
Given user is on login page
When user enters valid email address "parag@test.com"
And use enters valid password "12345"
And user clicks on Login button
Then user successfully logged in

Scenario: Login with invalid credentials
Given user is on login page
When user enters invalid email address "parag1@test.com"
And use enters invalid password "1234"
And user clicks on Login button
Then user gets invalid credentials warning message

Scenario: Login with valid email address and invalid password
Given user is on login page
When user enters valid email address "parag@test.com"
And use enters invalid password "1234"
And user clicks on Login button
Then user gets invalid credentials warning message

Scenario: Login with invalid email address and valid password
Given user is on login page
Given user enters invalid email address "parag1@test.com"
And use enters valid password "12345"
And user clicks on Login button
Then user gets invalid credentials warning message

Scenario: Login without any credentials
Given user is on login page
When user enters email address ""
And user enters password ""
And user clicks on Login button
Then user gets invalid credentials warning message





