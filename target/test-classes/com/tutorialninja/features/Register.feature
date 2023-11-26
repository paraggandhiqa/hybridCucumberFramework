Feature: Registration functionality

@register
Scenario: Create account with only mandatory fields
Given user is on register page
When user enters details as below
|firstName	|parag|
|lastName		|gandhi|
|telephone	|2334423|
|password		|12345|
|confirmPassword		|12345|
And user selects privacy policy
And user clicks on continue button
Then user account creates successfully

@register1
Scenario:  Create account with all fields
Given user is on register page
When user enters details as below
|firstName	|parag|
|lastName		|gandhi|
|telephone	|2334423|
|password		|12345|
And user selects Yes for newsletter
And user selects privacy policy
And user clicks on continue button
Then user account creates successfully

@register2
Scenario:  Create duplicate account
Given user is on register page
When user enters details as below
|firstName	|parag|
|lastName		|gandhi|
|email			|parag@test.com|
|telephone	|2334423|
|password		|12345|
And user selects Yes for newsletter
And user selects privacy policy
And user clicks on continue button
Then user gets duplicate email warning message

@register3
Scenario:  Create account without filling any details
Given user is on register page
And user clicks on continue button
Then user gets mandatory fields warning messages



