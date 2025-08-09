Feature: Login into Onion Test Management Tool #https://dev.onion.gnapitech.org

Scenario: User is shown Home Page Title
Given user opens the onion url on the browser
When user is able to read the title
Then user should be displayed the title "Sign in to Onion"

Scenario: User can click on Forgot password
Given user opens the onion url on the browser
When user clicks on forgot password
Then user should be displayed forgot password page

Scenario Outline: Login into Onion tool 
Given user opens the onion url on the browser
When user inputs "<username>" and "<password>" 
And Clicks on Sign In button
Then user should be allowed to login and navigate to home page and tile should be "Web"

Examples:
|username|password|
|onion@gnapi.tech|Gnapi@1234|