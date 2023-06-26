Feature: User
  As a doctor
  I want to see list of doctor
  So that I can to do task as doctor

  Feature: Auth
  As an user
  I want to create article as doctor
  So that I can access my article

#  ini positif case resep by dokter
  Scenario: ReceiptPos - Receipt success post
    Given I set to post API Endpoint
    When I send to post HTTP Request
    Then I receive valid HTTP Response 200
    And I receive valid data for create receipt

#    ini negatif case resep by dokter
  Scenario: ReceiptNeg - Receipt failed post
    Given I set API Endpoint
    When I send HTTP Request
    Then I receive invalid HTTP with Response code 404
    And I receive response body error email is required