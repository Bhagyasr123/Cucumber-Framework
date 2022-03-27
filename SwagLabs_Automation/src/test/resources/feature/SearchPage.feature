@tag
Feature: Feature to test image search functionality

  @tag1
  Scenario: User can open the last image appearing on image search results for any search
    Given user is on google page
    When user enter 'Trump' in search box
    And click on google search button
    And user click on image result 
    And user scroll down till the bottom of result page
    Then user click on the last image available
