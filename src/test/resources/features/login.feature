Feature: User
  As a doctor
  I want to see list of doctor
  So that I can to do task as doctor

  Feature: Auth
  As an user
  I want to create login as doctor
  So that I can access my homepage
# ini positif case login as docter
  Scenario: LoginPos - As admin I have be able to login existing user account
    Given I set Post API endpoint
    When I send Post HTTP request
    Then I receive valid HTTP Response code is 200
    And I receive valid data for existing user account

    # ini positif case login as dokter
  Scenario: LoginNeg - Login failed email empty
    Given I set POST API endpoint
    When User send request body login failed email empty
    Then User receive response code 500
    And User receive response body error email is required




