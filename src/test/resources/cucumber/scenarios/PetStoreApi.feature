Feature: Pet Store API

  Scenario: Verification of CRUD operations
    When I create pet with name parameter "pit bull"
    Then I check created pet exists and has "expected" name
    When I update current pet with new name parameter "stafford"
    Then I check created pet exists and has "updated" name
    When I delete current pet
    Then I check current pet doesn't exist
