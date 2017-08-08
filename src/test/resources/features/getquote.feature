Feature: As a small organisation, I should be able to get quote for 10+ employees

  Background:
    Given user is on Moo homepage

  Scenario: User should have the option to get quote
    When user wants to order for ten plus employees
    Then user can get a quote
    And user is asked for details for getting quote