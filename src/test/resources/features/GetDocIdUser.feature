Feature: GetDoctorIdUser
  As an admin
  I want to see doctor by id
  So that I can order doctor

  Scenario: GET - As admin I have be able to get doctor by id i input
    Given I set GET api endpoints
    When I send GET http request
    Then I receive valid http response code 200
    And I receive valid data for doctor i choose

  Scenario: GET - As admin I have be able to prevented to get doctor by id i input
    Given I set GET API endpoints
    When I Send GET HTTP Request
    Then I receive valid http response code is 200
    And I receive blank data doctor