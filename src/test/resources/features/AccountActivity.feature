Feature: Account Activity Page information test

  Background:
    Given the user is on the login page
    Then the user enters valid username and password
    Then the user navigates Online Banking - Account Activity

  Scenario: Account Summary Page should have the Title: Zero - Account summary
    Then the user should see the title "Account Activity"


  Scenario: Dropdown default option check
    Then Account drop down default option should be "Savings"


  Scenario: Account dropdown options check
    Then Account dropdown should have the following options:
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |


  Scenario: Transaction table column check
    Then Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |