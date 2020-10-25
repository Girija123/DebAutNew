Feature: As a user
         I do search to get products

  Scenario: Validate Search with valid searchTerm

    Given I'm on homepage
    When  I enter searchTerm "T-Shirt"
    When I click searchIcon
    Then I should see list of appropriate products
