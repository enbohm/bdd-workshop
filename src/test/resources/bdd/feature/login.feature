@LoginScenario
Feature: Login user
 
Scenario: User logs in with correct credentials 
 
Given a user on start page
And the user is not logged in
When user fills in username chuck and password norris
Then the user should be redirected to MyPages