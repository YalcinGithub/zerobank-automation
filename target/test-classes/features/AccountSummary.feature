Feature: Account summary page informations test

  Background:
    Given the user is on the login page
    Then the user enters valid username and password
    Then the user navigates Online Banking - Account Summary

  Scenario: Account Summary Page should have the Title: Zero - Account summary
    Then the user should see the title "Account Summary"

  Scenario: Account type check
    Then the user should see four account types

  Scenario: Credit Accounts table check
    Then the user should see three Credit Account Volumes