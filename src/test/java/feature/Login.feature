Feature: Login feature

  Scenario: User should be able to log in with valid credentials
    Given User should be on the login screen
    When User enter valid username and password
    And User click on the login button
    Then User should be navigate to the inventory page
    But User should not be on the login page

  Scenario: User should not be able to login with an invalid password
    Given User should be on the login screen
    When User enter "standard_user" on the username filed
    And User enter "secret_s" on the password filed
    And User click on the login button
    Then User should see "Epic sadface: Username and password do not match any user in this service" error message
