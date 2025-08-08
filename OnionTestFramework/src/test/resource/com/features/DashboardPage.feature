Feature: The functionalities on User Dashboard to be automated here

Background:
Given user login into the account using login creds
|username|password|
|onion@gnapi.tech|Gnapi@1234|

Scenario: User is able to view an option to Search Project
Given user is on dashboard
When user enters project name "Onion" 
And clicks enter
Then user should be navigated to Test page