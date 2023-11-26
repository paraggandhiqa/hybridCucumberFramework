Feature: Search functionality

Scenario: Search with valid product
Given user is on search page
When user enters product "iphone"
And user clicks on search
Then user gets searched product in search result


Scenario: Search with invalid product
Given user is on search page
When user enters product "test"
And user clicks on search
Then user gets no product found warning message

Scenario: Search without any product
Given user is on search page
When user dont enter any product
And user clicks on search
Then user gets no product found warning message





