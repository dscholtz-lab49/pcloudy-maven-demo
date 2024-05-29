@TestWeb
Feature: This is a demo feature for Website Test Automation

  Scenario: Open webpage and validate personal menu is displayed
    When User opens ABCB website
    Then Personal menu is visible

  Scenario: Open webpage and validate business menu is displayed
    When User opens ABCB website
    Then Business menu is visible