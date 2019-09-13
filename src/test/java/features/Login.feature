Feature: Login

  Background: Browser is opened

  Scenario Outline: Login with valid credentials
    Given User is on Login page
    When User login with valid <username> and <password>
    Then User is logged in

    Examples:
    |username | password |
    |aaaa     | afdasf   |
    |bbbb     | afdasf   |


