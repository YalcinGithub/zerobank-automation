Feature: Pay Bills Page information test

  Background:
    Given the user is on the login page
    Then the user enters valid username and password
    Then the user navigates Online Banking - Pay Bills Page

  Scenario: Pay Bills Page should have the Title: Zero – Pay Bills
    Then the user should see the title "Pay Bills"


  Scenario: Making successful payment check
    Then the user should be able input Amount and Date
    Then the user should see the message "The payment was successfully submitted." after payment


  Scenario: Handling invalid Inputs of Amount and Date
    Then if the user inputs nothing, gets Error message
    Then if the user inputs only date, gets Error message
    And if the user inputs only amount, gets Error message


  Scenario: Handling invalid Inputs of Amount and Date
    Then if the user inputs invalid date, it is not accepted