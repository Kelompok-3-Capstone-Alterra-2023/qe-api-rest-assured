Feature: Auth
  As an user
  I want to login
  So that I can access my dashboard


  Scenario: POST - As user I have be able to login existing user account
    Given I set Post API endpoint
    When I send Post HTTP request
    Then I receive valid HTTP Response code is 200
    And I receive valid data for existing user account

  Scenario: POST - As user I have be able to prevented to login
    Given I set POST API endpoint
    When I send POST HTTP request
    Then I receive valid HTTP Response code is 400
    And I prevented to login with error message