Feature: Random User Search

  Scenario: Validate the result with Facebook profile exists for random user
    When I execute API precondition to get random user and save name to Context
    Then I search for saved to Context user's name and surname in Google
    Then I validate the result with Facebook profile for this person
