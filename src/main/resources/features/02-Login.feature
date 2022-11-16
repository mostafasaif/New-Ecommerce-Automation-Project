Feature: SC2- User could log in
  Background:
    Given user navigate to home page
    And user clicked on login link


  @scenario2
  Scenario: SC2- User could log in with valid email and password
    And user clicked on login link
    And user entered email for login
    And user entered password for login
    And user clicked on login button
    Then  user should have a success message for login

  @scenario3
  Scenario: SC3- User could reset his/her password successfully
    And user clicked on forgot password
    And user entered email for reset password
    And user clicked on recover button
    Then user should have a success message for recover






