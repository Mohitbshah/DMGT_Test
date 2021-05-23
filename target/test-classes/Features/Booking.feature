@regression
Feature: This feature will make sure booking holidays with accommodation

  Scenario: I should see the accommodation selected amount and payment to be amount should be same
    Given I am on homepage
    When I enter country name in search box
    And I navigate to available holidays in the country mentioned
    And I click more info on the first result
    And I navigate to chosen holiday page
    And I click on Book Online
    And I navigate to calender with holiday first available date
    And I click continue button on the calender page
    And I navigate to accommodation Page
    And I select standardOrDouble room
    And I continue without extras
    And I navigate to passenger details form
    And I enters passengers details
    Then I navigate to payment page with all selected accommodation details



