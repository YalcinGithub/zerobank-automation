@Login
Feature: Users should be able to login
  Background:
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user enters valid username and password
    Then the user should be able to login

  Scenario Outline: Login with invalid credentials
    When user tries to login with invalid "<username>" or "<password>"
    Then error message Login and|or password are wrong should be displayed
    Examples:
      | username | password |
      | sdf      | ase      |
      | username | ase      |
      | dfs      | password |