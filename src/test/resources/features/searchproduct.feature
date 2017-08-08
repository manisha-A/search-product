Feature: Search For a Product
  In order to talk better
  As an English student
  I want to look up word definitions

  Background:
    Given user is on Moo homepage

  Scenario: Search for Valid Product
    When user searches for "Buisness Cards"
    Then user should search results for "Business Cards"

  Scenario: Search for Invalid Product
    When user searches for "randomstring"
    Then user should be notified for product not found