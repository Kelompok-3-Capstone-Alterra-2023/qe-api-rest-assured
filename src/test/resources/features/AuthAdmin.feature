Feature: AuthAdmin
  As an admin
  I want to login
  So that I can manage user and doctor


  Scenario: POST - As admin I have be able to login to my own system
    Given I set Post API Endpoint
    When I send Post HTTP Request
    Then I receive valid HTTP Response code 200
    And I receive valid data for my own admin account

  Scenario: POST - As admin I have be able to prevented to login
    Given I set POST API Endpoint
    When I send POST HTTP Request
    Then I receive valid HTTP Response code 500
    And I prevented to login with Error message