Feature: As a User, I should have the ability to sign in to my account

  Background:
    Given user is on Moo homepage

  Scenario: User should have the option to login with her facebook account
    When user wants to signin
    Then user is asked to login
    Then user should has option to signin with facebook