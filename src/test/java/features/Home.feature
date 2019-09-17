Feature: Home Page

  Scenario: Footer amount of footer links
    Given User is on Home page
    When User scrolls into view to the footer
    Then He sees four types of planes

  Scenario: Four Test preparations are displayed from Courses DD
    Given User is on Home page
    When User move courser to the Courses DD
    Then Four Test Prep links are displayed

  Scenario: User can go to SAT tests
    Given User is on Home page
    When User move courser to the Courses DD
    And User move courser to Popular Tests DD
    And User click SAT test link
    Then Page title contains SAT
