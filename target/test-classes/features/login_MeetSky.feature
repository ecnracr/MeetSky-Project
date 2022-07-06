@MTSK-425
Feature: As a user, I should be able to login.

  @MTSK-415
  Scenario Outline: User should be able to login with valid credentials

    Given User goes to login page
    When User enters "<username>" username
    When User enters "<password>" password
    When User clicks on login button
    Then User should be logged in

    Examples:
      | username   | password    |
      | Employee51 | Employee123 |

  @MTSK-416
  Scenario Outline: User shouldn't be able to login with credentials less than 2 more than 15 characters
    Given User goes to login page
    When User enters "<username>" username
    When User enters "<password>" password
    When User clicks on login button
    Then User should see Wrong username or password message

    Examples:
      | username                       | password                       |
      | A                              | Employee123                    |
      | Employee51Employee51Employee51 | Employee123                    |
      | Employee51                     | A                              |
      | Employee51                     | Employee51Employee51Employee51 |
      | A                              | A                              |
      | Employee51Employee51Employee51 | Employee51Employee51Employee51 |

  @MTSK-418
  Scenario Outline: User shouldn't be able to login with empty credentials
    Given User goes to login page
    When User enters "<username>" username
    When User enters "<password>" password
    When User clicks on login button
    Then User shouldn't be able to login and should see error message
    Examples:
      | username   | password    |
      |            | Employee123 |
      | Employee51 |             |
      |            |             |

  @MTSK-417
  Scenario Outline: User shouldn't be able to login with invalid credentials
    Given User goes to login page
    When User enters "<username>" username
    When User enters "<password>" password
    When User clicks on login button
    Then User shouldn't be able to login and should see error message
    Examples:
      | username   | password    |
      | Ece        | Employee123 |
      | Employee51 | Ece         |
      | Ece        | Ece         |


  @MTSK-419
    Scenario Outline: User should be able to see the password in a form of dots by default
    Given User goes to login page
    When User enters "<password>" password
    Then User should see the password in a form of dots
    Examples:
      | password     |
      | Employee123  |

  @MTSK-420
    Scenario Outline: User should be able to see the password explicitly if needed
    Given User goes to login page
    When User enters "<password>" password
    When User clicks on eye icon
    Then User should see the password in a form of text
    Examples:
      | password     |
      | Employee123  |

  @MTSK-421
    Scenario: User should be able to see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
    Given User goes to login page
    When User clicks on Forgot password link
    Then User should see the Reset Password button

  @MTSK-422
    Scenario: User should be able to see valid placeholders on Username and Password fields
    Given User goes to login page
    When User sees the "Username or email" and "Password" placeholders