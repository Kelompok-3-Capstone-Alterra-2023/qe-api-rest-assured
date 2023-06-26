Feature: SearchArticle
  As an user
  I want to search article
  So that I can see and choose article i want to read

  Scenario: GET - As user I have be able to search article by keyword i input
    Given I set GET api endpoint
    When I send GET HTTP Request
    Then I receive valid HTTP response code is 200
    And I receive valid data for article based on my keyword

  Scenario: GET - As user I have be able to get blank page for article keyword i input
    Given I set GET API endpoint
    When I send GET HTTP request
    Then I Receive valid HTTP response code is 200
    And I receive blank data for article based on my false keyword