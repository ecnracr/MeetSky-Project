@MTSK-426
Feature: As a user, I should be able to log out.

  @MTSK-423
    Scenario: User should be able to log out and ends up in login page
    Given User logs in with valid credentials
    Given User click to settings expand button on top-right corner
    When Click to Log out button
    Then User should be able to logged out successfully and can see the login page

  @MTSK-424
    Scenario:User shouldn't be able to go to the home page again by clicking step back button after successfully logged out
    Given User logs in with valid credentials
    Given User click to settings expand button on top-right corner
    When Click to Log out button
    Then User should be able to logged out successfully and can see the login page
    And User should not be able to go to home page again by clicking step back button

