
Feature: Application Login
Background:
Given user lands on webPage
When user lands on homepage
Then clears the cache
  
  @tag1
  Scenario: Admin page login
    Given user is on website
    When user logs in to application
    Then homepage is displayed
    And check more outcomes

