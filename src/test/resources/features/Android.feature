@TestMobile
Feature: This is a demo feature file for apk installation

  Scenario: Install app and open it
    Given User install "ExpenseApp"
    When User opens "ExpenseApp"
    Then Application is loaded with all elements