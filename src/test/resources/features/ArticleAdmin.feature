Feature: ArticleAdmin
  As an admin
  I want to approve or reject an article
  So that I can let doctor's article published or not

  Scenario: PUT - As admin I have be able to approve an article
    Given I set PUT API endpoint
    When I send PUT Http Request
    Then I receive valid Http response code is 200
    And I receive valid data for approved article

  Scenario: PUT - As admin I have be able prevented to approve an article
    Given I set PUT API Endpoint
    When I send PUT Http request
    Then I receive valid Http response code is 500
    And I receive error message and prevented to approve an article

  Scenario: PUT - As admin I have be able to reject an article
    Given I Set PUT API endpoint
    When I Send PUT Http Request
    Then I Receive valid Http response code is 200
    And I receive valid data for rejected article

  Scenario: PUT - As admin I have be able prevented to reject an article
    Given I Set PUT API Endpoint
    When I Send PUT Http request
    Then I Receive valid Http response code is 500
    And I receive error message and prevented to reject an article
