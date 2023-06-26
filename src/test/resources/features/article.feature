Feature: User
  As a doctor
  I want to see list of doctor
  So that I can to do task as doctor

  Feature: Auth
  As an user
  I want to create article as doctor
  So that I can access my article
#ini positif case artikel
  Scenario: ArticlePos - Article success post
    Given I set post API Endpoint
    When I send post HTTP Request
    Then I receive valid HTTP Response code 200
    And I receive valid data for create article

# karena ada bug di case negatif jadi ditulis dalam bug report
